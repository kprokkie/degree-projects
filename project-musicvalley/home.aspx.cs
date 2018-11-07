using System;
using System.Collections;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.HtmlControls; 
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Xml.Linq;
using System.Data.SqlClient;

public partial class Default2 : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (Membership.GetUser() != null)
        {
            MembershipUser user = Membership.GetUser();
            Guid userid = new Guid(user.ProviderUserKey.ToString());
            string username = user.UserName;
            string name = username;
            if (name == "admin")
                Response.Redirect("admin.aspx");
        }
    }
    private void temptable()
    { 
        DataTable tb = new DataTable("tbcart");

        DataColumn col = new DataColumn();
        col.ColumnName = "cartID";
        col.DataType = Type.GetType("System.Int32");
        col.AutoIncrement = true;
        col.AutoIncrementSeed = 1;
        col.AutoIncrementStep = 1;
        tb.Columns.Add(col);

        tb.Columns.Add(new DataColumn("proID", Type.GetType("System.Int32")));
        tb.Columns.Add(new DataColumn("proName", Type.GetType("System.String")));
        tb.Columns.Add(new DataColumn("proDetail", Type.GetType("System.String")));
        tb.Columns.Add(new DataColumn("proPrice", Type.GetType("System.Int32")));

        DataColumn[] pk = new DataColumn[1];
        DataColumn[] pk1 = new DataColumn[2];
        pk[0] = tb.Columns[0];
        tb.PrimaryKey = pk;
        pk1[0] = tb.Columns[1];
        tb.PrimaryKey = pk1;
         
        Session["sa"] = tb;
    }
    protected void ListView1_ItemCommand(object sender, ListViewCommandEventArgs e)
    {
            if (e.CommandName == "add")
            {
                Int32 count;
                try
                {
                    count = Convert.ToInt32(Request.Cookies["cnt"].Value);
                }
                catch
                {
                    temptable();
                    Response.Cookies["cnt"].Value = 1.ToString();
                }
                Label l = (Label)(Master.FindControl("Label2"));
                Int32 ID, price;
                string name, detail;
                ID = Convert.ToInt32(((Label)(e.Item.FindControl("proIDLabel"))).Text);
                name = ((Label)(e.Item.FindControl("proNameLabel"))).Text;
                detail = ((Label)(e.Item.FindControl("proDetailLabel"))).Text;
                price = Convert.ToInt32(((Label)(e.Item.FindControl("proPriceLabel"))).Text);

                DataTable tab = (DataTable)(Session["sa"]);
                DataRow r = tab.NewRow();
                r[1] = ID;
                r[2] = name;
                r[3] = detail;
                r[4] = price;

                try
                {
                    tab.Rows.Add(r);
                    Session["cart"] = tab;
                    l.Text = " " + tab.Compute("count(cartID)", " ").ToString();
                }
                catch
                {
                    string script = "<script> alert('" + "ALREADY ADDED TO CART" + "')</script>";
                    Response.Write(script);
                    l.Text = " " + tab.Compute("count(cartID)", " ").ToString();
                }
            }
    }
}