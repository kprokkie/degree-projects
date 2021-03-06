﻿using System;
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

public partial class Default3 : System.Web.UI.Page
{
    SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["cns1"].ConnectionString);
    protected void Page_Load(object sender, EventArgs e)
    {
        con.Open();
        if (!Page.IsPostBack)
            bind();
    }
    private void bind()
    {
        SqlDataAdapter adp = new SqlDataAdapter("select * from product_Detail", con);
        DataSet ds = new DataSet();
        adp.Fill(ds);
        GridView1.DataSource = ds;
        GridView1.DataBind();
    }
    protected void GridView1_RowEditing(object sender, GridViewEditEventArgs e)
    {
        GridView1.EditIndex = e.NewEditIndex;
        bind();
    }
    protected void GridView1_RowCancelingEdit(object sender, GridViewCancelEditEventArgs e)
    {
        GridView1.EditIndex = -1;
        bind();
    }
    protected void GridView1_RowUpdating(object sender, GridViewUpdateEventArgs e)
    {
        Int32 Price,ID,Rating;
        string Name,Detail,Category;
        ID = Convert.ToInt32(GridView1.DataKeys[e.RowIndex].Value);
       Name = ((TextBox)(GridView1.Rows[e.RowIndex].FindControl("TextBox1"))).Text;
        Detail = ((TextBox)(GridView1.Rows[e.RowIndex].FindControl("TextBox2"))).Text;
       Price = Convert.ToInt32(((TextBox)(GridView1.Rows[e.RowIndex].FindControl("TextBox3"))).Text);
        Category = ((DropDownList)(GridView1.Rows[e.RowIndex].FindControl("DropDownList1"))).SelectedValue;
       Rating = Convert.ToInt32(((DropDownList)(GridView1.Rows[e.RowIndex].FindControl("DropDownList2"))).SelectedValue);
        
        string q = "update product_Detail set proName=@Name,proDetail=@Detail,proPrice=@Price,proCategory=@Category,proRating=@Rating where proID=@ID";
        SqlCommand cmd = new SqlCommand(q, con);
       
        cmd.Parameters.Add("@ID", SqlDbType.Int).Value = ID;
        cmd.Parameters.Add("@Name", SqlDbType.VarChar, 50).Value = Name;
        cmd.Parameters.Add("@Detail", SqlDbType.VarChar, 50).Value = Detail;
        cmd.Parameters.Add("@Price", SqlDbType.Int).Value = Price;
        cmd.Parameters.Add("@Category", SqlDbType.VarChar, 50).Value = Category; 
        cmd.Parameters.Add("@Rating", SqlDbType.Int).Value = Rating;

        cmd.ExecuteNonQuery();
        cmd.Dispose();
        con.Close();
        GridView1.EditIndex = -1;
        bind();






    }
    protected void GridView1_RowDeleting(object sender, GridViewDeleteEventArgs e)
    {
        string q = "delete from product_Detail where proID=@proID";
        SqlCommand cmd = new SqlCommand(q, con);
        
        cmd.Parameters.Add("@proID", SqlDbType.Int).Value = Convert.ToInt32(GridView1.DataKeys[e.RowIndex].Value);
        cmd.ExecuteNonQuery();
        cmd.Dispose();
        con.Close(); 
        bind();
    }
    protected void GridView1_PageIndexChanging(object sender, GridViewPageEventArgs e)
    {
        GridView1.PageIndex = e.NewPageIndex;
        bind();
    }
    //protected void GridView1_RowCommand(object sender, GridViewCommandEventArgs e)
    //{
    //    if (e.CommandName == "save")
    //    {
    //        string q = "insert into product_Detail";
    //        SqlCommand cmd = new SqlCommand(q, con);
            
    //        cmd.Parameters.Add("@id", SqlDbType.Int).Value = Convert.ToInt32(((TextBox)(GridView1.FooterRow.FindControl("TextBox4"))).Text);
    //        cmd.Parameters.Add("@nam", SqlDbType.VarChar, 50).Value = ((TextBox)(GridView1.FooterRow.FindControl("TextBox5"))).Text;
    //        cmd.Parameters.Add("@add", SqlDbType.VarChar, 50).Value = ((TextBox)(GridView1.FooterRow.FindControl("TextBox6"))).Text;
    //        cmd.Parameters.Add("@mks", SqlDbType.Int).Value = Convert.ToInt32(((TextBox)(GridView1.FooterRow.FindControl("TextBox7"))).Text);
    //        cmd.ExecuteNonQuery();
    //        cmd.Dispose();
    //        con.Close();
    //        bind();
    //    }
    //}



    protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
}