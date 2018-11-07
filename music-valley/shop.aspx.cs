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

    protected void ListBox1_SelectedIndexChanged(object sender, EventArgs e)
    {
        //Label4.Text = ListBox1.SelectedValue; 

    }
    protected void ListBox2_SelectedIndexChanged(object sender, EventArgs e)
    {
       // Label3.Text = DateTime.Now.ToShortDateString();

       //DateTime date = DateTime.Now.Date;

       //Label4.Text = date.ToString();
    
    }


    protected void DropDownList1_SelectedIndexChanged(object sender, EventArgs e)
    {

    }

    protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
}
    
