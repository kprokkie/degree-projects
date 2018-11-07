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

public partial class Admin : System.Web.UI.MasterPage
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (Membership.GetUser() != null)
        {
            MembershipUser user = Membership.GetUser();
            Guid userid = new Guid(user.ProviderUserKey.ToString());
            string username = user.UserName;
            string name = username;
            Label1.Text = name;
        }
        try
        {
            Label2.Text = Request.Cookies["item"].Value;
        }
        catch
        {
            Label2.Text = "0";
        }
    }
    private void access()
    {
        if (Membership.GetUser() != null)
        {
            MembershipUser user = Membership.GetUser();
            Guid userid = new Guid(user.ProviderUserKey.ToString());
            string username = user.UserName;
            string name = username;
            Label1.Text = name;
            if (name == "admin")
                Response.Redirect("genre.aspx");
            else
                Response.Redirect("product.aspx");
        }
        else
            Response.Redirect("product.aspx");
    }
    protected void LinkButton1_Click(object sender, EventArgs e)
    {
        Response.Cookies["msg"].Value = LinkButton1.Text;
        access();
    }
    protected void LinkButton2_Click(object sender, EventArgs e)
    {
        Response.Cookies["msg"].Value = LinkButton2.Text;
        access();
    }
    protected void LinkButton10_Click(object sender, EventArgs e)
    {
        Response.Cookies["msg"].Value = LinkButton10.Text;
        access();
    }
    protected void LinkButton7_Click(object sender, EventArgs e)
    {
        Response.Cookies["msg"].Value = LinkButton7.Text;
        access();
    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        Response.Cookies["msg"].Value = TextBox1.Text;
        Response.Redirect("find.aspx");
    }
    protected void LinkButton3_Click(object sender, EventArgs e)
    {
        Response.Cookies["msg"].Value = LinkButton3.Text;
        access();
    }
    protected void LinkButton4_Click(object sender, EventArgs e)
    {
        Response.Cookies["msg"].Value = LinkButton4.Text;
        access();
    }
    protected void LinkButton5_Click(object sender, EventArgs e)
    {
        Response.Cookies["msg"].Value = LinkButton5.Text;
        access();
    }
    protected void LinkButton6_Click(object sender, EventArgs e)
    {
        Response.Cookies["msg"].Value = LinkButton6.Text;
        access();
    }
    protected void LinkButton8_Click(object sender, EventArgs e)
    {
        Response.Cookies["msg"].Value = LinkButton8.Text;
        access();
    }
    protected void LinkButton9_Click(object sender, EventArgs e)
    {
        Response.Cookies["msg"].Value = LinkButton9.Text;
        access();
    }
    protected void LinkButton15_Click(object sender, EventArgs e)
    {
        if (Membership.GetUser() != null)
        {
            MembershipUser user = Membership.GetUser();
            Guid userid = new Guid(user.ProviderUserKey.ToString());
            string username = user.UserName;
            string name = username;
            Label1.Text = name;
            if (name == "admin")
                Response.Redirect("admin.aspx");
            else
                Response.Redirect("home.aspx");
        }
        else
            Response.Redirect("home.aspx");
    }
    protected void LinkButton16_Click(object sender, EventArgs e)
    {
        Response.Redirect("catalog.aspx");
    }
    protected void LinkButton17_Click(object sender, EventArgs e)
    {
        string script;
        if (Membership.GetUser() != null)
        {
            MembershipUser user = Membership.GetUser();
            Guid userid = new Guid(user.ProviderUserKey.ToString());
            string username = user.UserName;
            string name = username;
            if (name == "admin")
            {
                Response.Redirect("shop.aspx");
            }

            else
                Response.Redirect("cart.aspx");
        }
        else
        {
            script = "<script> alert('" + "NOT A REGISTERED MEMBER." + "')</script>";
            Response.Write(script);
        }
    }
    protected void LinkButton18_Click(object sender, EventArgs e)
    {
        Response.Redirect("category.aspx");
    }
    protected void LinkButton19_Click(object sender, EventArgs e)
    {
        Response.Redirect("shop.aspx");
    }
    protected void LinkButton20_Click(object sender, EventArgs e)
    {
        Response.Redirect("aboutus.aspx");
    }
    protected void LinkButton21_Click(object sender, EventArgs e)
    {
        Response.Redirect("admin.aspx");
    }
    protected void LinkButton22_Click(object sender, EventArgs e)
    {
        Response.Redirect("catalog.aspx");
    }
    protected void LinkButton23_Click(object sender, EventArgs e)
    {
        Response.Redirect("category.aspx");
    }
    protected void LinkButton24_Click(object sender, EventArgs e)
    {
        Response.Redirect("aboutus.aspx");
    }
}

