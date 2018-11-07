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
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    private void access()
    {
        if (Membership.GetUser() != null)
        {
            MembershipUser user = Membership.GetUser();
            Guid userid = new Guid(user.ProviderUserKey.ToString());
            string username = user.UserName;



            //Response.Write(username); 
            string name = username;
            //Label1.Text = name;
            if (name == "admin")
                Response.Redirect("genre.aspx");
            else
                Response.Redirect("product.aspx");


        }
        else
            Response.Redirect("product.aspx");
    }
    protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
    {
        Response.Cookies["msg"].Value = "CONTEMPORY";
        access();
    }
    protected void ImageButton2_Click(object sender, ImageClickEventArgs e)
    {
        Response.Cookies["msg"].Value = "COUNTRY";
        access();
    }
    protected void ImageButton3_Click(object sender, ImageClickEventArgs e)
    {
        Response.Cookies["msg"].Value = "CLASSICAL";
        access();
    }
    protected void ImageButton4_Click(object sender, ImageClickEventArgs e)
    {
        Response.Cookies["msg"].Value = "JAZZ";
        access();
    }
    protected void ImageButton5_Click(object sender, ImageClickEventArgs e)
    {
        Response.Cookies["msg"].Value = "HIPHOP";
        access();
    }
    protected void ImageButton6_Click(object sender, ImageClickEventArgs e)
    {
        Response.Cookies["msg"].Value = "POP";
        access();
    }
    protected void ImageButton7_Click(object sender, ImageClickEventArgs e)
    {
        Response.Cookies["msg"].Value = "RAGGAE";
        access();
    }
    protected void ImageButton8_Click(object sender, ImageClickEventArgs e)
    {
        Response.Cookies["msg"].Value = "ROCK";
        access();

    }
    protected void ImageButton9_Click(object sender, ImageClickEventArgs e)
    {
        Response.Cookies["msg"].Value = "DANCE";
        access();
    }
    protected void ImageButton10_Click(object sender, ImageClickEventArgs e)
    {
        Response.Cookies["msg"].Value = "GAME";
        access();
    }
}