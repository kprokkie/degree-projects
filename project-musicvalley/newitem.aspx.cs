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
using System.IO;

public partial class Default3 : System.Web.UI.Page
{
    SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["cns1"].ConnectionString);
    protected void Page_Load(object sender, EventArgs e)
    {
        if (con.State == ConnectionState.Closed)
            con.Open();
        Label3.Text = "";
        getid();
    }
    private void getid()
    {
        string q = "select isnull(max(proID),0)from product_Detail";
        SqlCommand cmd = new SqlCommand(q, con);
        int l = Convert.ToInt32(cmd.ExecuteScalar()) + 1;
        TextBox3.Text = l.ToString();
        TextBox7.Text = (System.DateTime.Now).ToString();
        
    }
    protected void Button2_Click(object sender, EventArgs e)
    {
        string ext = Path.GetExtension(FileUpload1.PostedFile.FileName);
        string pic = Guid.NewGuid() + ext;
        string p = Server.MapPath("ProductImages");
        if (!p.EndsWith("\\"))
            p += "\\";
        p += pic;
        FileUpload1.PostedFile.SaveAs(p);
        Response.Write("file uploaded");
        Response.Write(pic);

        
            string q = "insert into product_Detail values(@id,@image,@name,@price,@detail,@category,@rating,@date)";
            SqlCommand cmd = new SqlCommand(q, con);

            cmd.Parameters.Add("@id", SqlDbType.Int).Value = Convert.ToInt32(TextBox3.Text);
            cmd.Parameters.Add("@image", SqlDbType.NVarChar).Value = pic;
            cmd.Parameters.Add("@name", SqlDbType.VarChar).Value = TextBox4.Text;
            cmd.Parameters.Add("@price", SqlDbType.Int).Value = Convert.ToInt32(TextBox6.Text);
            cmd.Parameters.Add("@detail", SqlDbType.NVarChar).Value = TextBox5.Text;
            cmd.Parameters.Add("@category", SqlDbType.VarChar, 50).Value = DropDownList1.SelectedValue;
            cmd.Parameters.Add("@rating", SqlDbType.Int).Value = Convert.ToInt32(DropDownList2.SelectedValue);
            cmd.Parameters.Add("@date", SqlDbType.Date).Value = System.DateTime.Now;

            cmd.ExecuteNonQuery();

            getid();
            cmd.Dispose();
            con.Close();
            TextBox4.Text = "";
            TextBox5.Text = "";
            TextBox6.Text = "";
            FileUpload1.Focus();
            Label3.Text = "* Last New Product Added successfully.";



      
    }
}