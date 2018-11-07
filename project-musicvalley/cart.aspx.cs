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
using System.Text;

public partial class Default3 : System.Web.UI.Page 
{   
    SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["cns1"].ConnectionString);
    string name;
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!Page.IsPostBack)
        {
            DataTable tab1 = (DataTable)(Session["cart"]);
            GridView1.DataSource = tab1;
            GridView1.DataBind();
            try
            {
                Label5.Text = "";
                Label3.Text = " " + tab1.Compute("sum(proPrice)", "").ToString();
                Label4.Text = " " + tab1.Compute("count(cartID)", " ").ToString();
                Response.Cookies["item"].Value = Label4.Text;
            }
            catch
            {
                Label3.Text = "0";
                Label4.Text = "0";
            }
        }
     }
    protected void GridView1_RowDeleting(object sender, GridViewDeleteEventArgs e)
    {
        DataTable tab1 = (DataTable)(Session["cart"]);
        Int32 id= Convert.ToInt32(GridView1.DataKeys[e.RowIndex].Value);
        Response.Write(""+id);
        tab1.Rows[id - 1].Delete(); 
        tab1.AcceptChanges();
        Int32 cnt = Convert.ToInt32 (tab1.Compute("count(cartID)", " ").ToString());
        for (int i = id; i<=cnt; i++)
        {
            tab1.Rows[i - 1]["cartID"] = i;
            tab1.AcceptChanges();
        }
        GridView1.DataSource = tab1;
        GridView1.DataBind();

        Label3.Text = " " + tab1.Compute("sum(proPrice)", "").ToString();
        Label4.Text = " " + tab1.Compute("count(cartID)", " ").ToString();
       
        Label l = (Label)(Master.FindControl("Label2"));
        l.Text = Label4.Text;
        Response.Cookies["item"].Value = Label4.Text;
    }
    private void InsertData()
    {
        SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["cns1"].ConnectionString);
        StringBuilder sb = new StringBuilder(string.Empty);
        DataTable tab1 = (DataTable)(Session["cart"]);
        if (tab1.Rows.Count > 0)
            {
                string userName = name;
                Int32 cartID = Convert.ToInt32(tab1.Rows[0]["cartID"].ToString());
                Int32 proID = Convert.ToInt32(tab1.Rows[0]["proID"].ToString());
                string proName = tab1.Rows[0]["proName"].ToString();
                string proDetail = tab1.Rows[0]["proDetail"].ToString();
                Int32 proPrice = Convert.ToInt32(tab1.Rows[0]["proPrice"].ToString());
                sb.AppendFormat("'{0}','{1}','{2}','{3}','{4}','{5}'",userName, cartID, proID, proName, proDetail, proPrice);
            }
        string sql = string.Format("INSERT INTO cart_Detail  (userName,cartID,proID,proName,proDetail,proPrice) VALUES ({0});", sb.ToString()); // But still i would suggest you to use SP or parameterize queries for security reasons

            con.Open();
            SqlCommand cmd = new SqlCommand(sql, con);
            cmd.CommandType = CommandType.Text;
            cmd.ExecuteNonQuery(); 
            cmd.Dispose();
            con.Close();

            con.Open();
            string q = "update cart_Detail set buyDate =@date where buyDate is NULL";
            SqlCommand cmd1 = new SqlCommand(q, con);
            cmd1.Parameters.Add("@date", SqlDbType.Date).Value = System.DateTime.Now;
            cmd1.ExecuteNonQuery();
            cmd1.Dispose();
            con.Close();
            tab1.Rows[0].Delete();
            tab1.AcceptChanges();
            Session["cart"] = tab1;
    }  
    protected void RadioButton1_CheckedChanged(object sender, EventArgs e)
    {
        Panel1.Visible = true;
        Panel2.Visible = false;
        Panel3.Visible = false;
    }
    protected void RadioButton2_CheckedChanged(object sender, EventArgs e)
    {
        Panel2.Visible = true;
        Panel1.Visible = false;
        Panel3.Visible = false;
    }
    protected void RadioButton3_CheckedChanged(object sender, EventArgs e)
    {
        Panel3.Visible = true;
        Panel1.Visible = false;
        Panel2.Visible = false;
    }
    protected void Button4_Click(object sender, EventArgs e)
    {
        if (Membership.GetUser() != null)
        {
            MembershipUser user = Membership.GetUser();
            Guid userid = new Guid(user.ProviderUserKey.ToString());
            string username = user.UserName;
            Int32 check = Convert.ToInt32(Label4.Text);
            if (check > 0)
                Panel4.Visible = true;
            else
                Label5.Text = "You havn't any product in cart.";
        }
        else
            Panel5.Visible = true;
    }
    protected void Button3_Click(object sender, EventArgs e)
    {
        if (Membership.GetUser() != null)
        {
            MembershipUser user = Membership.GetUser();
            Guid userid = new Guid(user.ProviderUserKey.ToString());
            string username = user.UserName;
            name = username;
            con.Open();
            string q = "select userName from user_Info where userName=@userName";
            SqlCommand cmd = new SqlCommand(q, con);
            cmd.Parameters.Add("@userName", SqlDbType.VarChar, 50).Value = username;
            SqlDataReader dr = cmd.ExecuteReader();
            dr.Read();
            if (dr.HasRows)
            {
                DataTable tab1 = (DataTable)(Session["cart"]);
                Int32 cnt = Convert.ToInt32(tab1.Compute("count(cartID)", " ").ToString());
                for (int i = cnt; i > 0; i--)
                {
                    InsertData();
                } 
                dr.Close();
                cmd.Dispose();
                con.Close();
            }
            else
            {
                string script = "<script> alert('" + "FILL UR DETAILS FIRST" + "')</script>";
                Response.Write(script);
                dr.Close();
                cmd.Dispose();
                con.Close();
            }
            Session["cart"] = null;
            Response.Cookies["item"].Value = 0.ToString();
            Response.Redirect("confirm.aspx");
        }
    }
    protected void Button5_Click(object sender, EventArgs e)
    {
        if (Membership.GetUser() != null)
        {
            MembershipUser user = Membership.GetUser();
            Guid userid = new Guid(user.ProviderUserKey.ToString());
            string username = user.UserName;
            name = username;
            con.Open();
            string q = "select userName from user_Detail where userName=@userName";
            SqlCommand cmd = new SqlCommand(q, con);
            cmd.Parameters.Add("@userName", SqlDbType.VarChar, 50).Value = username;
            SqlDataReader dr = cmd.ExecuteReader();
            dr.Read();
            if (dr.HasRows)
            {
                DataTable tab1 = (DataTable)(Session["cart"]);
                Int32 cnt = Convert.ToInt32(tab1.Compute("count(cartID)", " ").ToString());
                for (int i = cnt; i > 0; i--)
                {
                    InsertData();
                }
                dr.Close();
                cmd.Dispose();
                con.Close();
            }
            else
            {
                string script = "<script> alert('" + "FILL UR DETAILS FIRST" + "')</script>";
                Response.Write(script);
                dr.Close();
                cmd.Dispose();
                con.Close();
            }
            Session["cart"] = null;
            Response.Cookies["item"].Value = 0.ToString();
            Response.Redirect("confirm.aspx");
        }
    }
    protected void Button6_Click(object sender, EventArgs e)
    {
        if (Membership.GetUser() != null)
        {
            MembershipUser user = Membership.GetUser();
            Guid userid = new Guid(user.ProviderUserKey.ToString());
            string username = user.UserName;
            name = username;
            con.Open();
            string q = "select userName from user_Detail where userName=@userName";
            SqlCommand cmd = new SqlCommand(q, con);
            cmd.Parameters.Add("@userName", SqlDbType.VarChar, 50).Value = username;
            SqlDataReader dr = cmd.ExecuteReader();
            dr.Read();
            if (dr.HasRows)
            {
                DataTable tab1 = (DataTable)(Session["cart"]);
                Int32 cnt = Convert.ToInt32(tab1.Compute("count(cartID)", " ").ToString());
                for (int i = cnt; i > 0; i--)
                {
                    InsertData();
                }
                dr.Close();
                cmd.Dispose();
                con.Close();
            }
            else
            {
                string script = "<script> alert('" + "FILL UR DETAILS FIRST" + "')</script>";
                Response.Write(script);
                dr.Close();
                cmd.Dispose();
                con.Close(); 
            }
            Session["cart"] = null;
            Response.Cookies["item"].Value = 0.ToString();
            Response.Redirect("confirm.aspx");
        }
    }
    protected void LinkButton18_Click(object sender, EventArgs e)
    {
        if (Membership.GetUser() != null)
        {
            MembershipUser user = Membership.GetUser();
            Guid userid = new Guid(user.ProviderUserKey.ToString());
            string username = user.UserName;
            Response.Redirect("userinfo.aspx");
        }
        else
            Panel5.Visible = true;
    }
    protected void GridView1_PageIndexChanging(object sender, GridViewPageEventArgs e)
    {
        DataTable tab1 = (DataTable)(Session["cart"]);
        GridView1.PageIndex = e.NewPageIndex;
        GridView1.DataSource = tab1;
        GridView1.DataBind();
    }
    protected void LinkButton19_Click(object sender, EventArgs e)
    {
        Response.Redirect("login.aspx");
    }
    protected void LinkButton20_Click(object sender, EventArgs e)
    {
        Response.Redirect("register.aspx");
    }
}