using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Default3 : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void LinkButton18_Click(object sender, EventArgs e)
    {
        Response.Redirect("catalog.aspx");
    }
    protected void LinkButton19_Click(object sender, EventArgs e)
    {
        Response.Redirect("category.aspx");
    }
    protected void LinkButton20_Click(object sender, EventArgs e)
    {
        Response.Redirect("newitem.aspx");
    }
    protected void LinkButton21_Click(object sender, EventArgs e)
    {
        Response.Redirect("shop.aspx");
    }
}