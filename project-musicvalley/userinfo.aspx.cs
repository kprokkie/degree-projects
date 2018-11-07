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

public partial class Default2 : System.Web.UI.Page
{
    string name;
    SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["cns1"].ConnectionString);
    protected void Page_Load(object sender, EventArgs e)
    {
        con.Open();
        if (!Page.IsPostBack)
        {
            if (Membership.GetUser() != null)
            {
                MembershipUser user = Membership.GetUser();
                Guid userid = new Guid(user.ProviderUserKey.ToString());
                string username = user.UserName;
                name = username;
                Label3.Text = name;
            }
            bind();
        }
    }
    private void bind()
    {
        SqlDataAdapter adp = new SqlDataAdapter("select * from user_Info where userName=@userName", ConfigurationManager.ConnectionStrings["cns1"].ConnectionString);
        adp.SelectCommand.Parameters.Add("@userName", SqlDbType.VarChar, 50).Value = Label3.Text;
        DataSet ds = new DataSet();
        adp.Fill(ds);
        FormView1.DataSource = ds;
        FormView1.DataBind();
    }
    protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
    {
        if (Membership.GetUser() != null)
        {
            MembershipUser user = Membership.GetUser();
            Guid userid = new Guid(user.ProviderUserKey.ToString());
            string username = user.UserName;
            name = username;
            Label3.Text = name;
        }
        string ext = Path.GetExtension(FileUpload1.PostedFile.FileName);
        string pic = Guid.NewGuid() + ext;
        string p = Server.MapPath("UploadImages");
        if (!p.EndsWith("\\"))
            p += "\\";
        p += pic;
        FileUpload1.PostedFile.SaveAs(p);
        //Response.Write("file uploaded");
        //Response.Write(pic);
        try
        {
            string q = "insert into user_Image values(@name,@pic)";
            SqlCommand cmd = new SqlCommand(q, con);
            cmd.Parameters.Add("@name", SqlDbType.VarChar).Value = name;
            cmd.Parameters.Add("@pic", SqlDbType.NVarChar).Value = pic;
            cmd.ExecuteNonQuery();
            cmd.Dispose();
            con.Close();
            //Response.Write("File inserted");
        }
        catch (Exception)
        {
            string q = "update user_Image set userPic=@pic where userName=@name";
            SqlCommand cmd = new SqlCommand(q, con);
            cmd.Parameters.Add("@name", SqlDbType.VarChar).Value = name;
            cmd.Parameters.Add("@pic", SqlDbType.NVarChar).Value = pic;
            cmd.ExecuteNonQuery();
            cmd.Dispose();
            con.Close();
            //Response.Write(" File updated");
        }
    }
    protected void FormView1_PageIndexChanging(object sender, FormViewPageEventArgs e)
    {
        FormView1.PageIndex = e.NewPageIndex;
        bind();
    }
    protected void FormView1_ModeChanging(object sender, FormViewModeEventArgs e)
    {
        if (e.NewMode == FormViewMode.Edit)
            FormView1.ChangeMode(FormViewMode.Edit);
        else if (e.NewMode == FormViewMode.Insert)
            FormView1.ChangeMode(FormViewMode.Insert);
        else
            FormView1.ChangeMode(FormViewMode.ReadOnly);
        bind();
    }
    protected void FormView1_ItemUpdating(object sender, FormViewUpdateEventArgs e)
    {
        UpdatePanel up1 = (UpdatePanel)(FormView1.FindControl("UpdatePanel7"));
        DropDownList dl1 = (DropDownList)(up1.FindControl("DropDownList9"));

        UpdatePanel up2 = (UpdatePanel)(up1.FindControl("UpdatePanel8"));
        DropDownList dl2 = (DropDownList)(up2.FindControl("DropDownList10"));

        UpdatePanel up3 = (UpdatePanel)(up2.FindControl("UpdatePanel9")); 
        DropDownList dl3 = (DropDownList)(up3.FindControl("DropDownList11"));

        string q = "update user_Info set firstName=@firstName,lastName=@lastName,userGender=@userGender,contactNumber=@contactNumber,userAddress=@userAddress,userCountry=@userCountry,userState=@userState,userCity=@userCity where userName=@userName";
        SqlCommand cmd = new SqlCommand(q, con);

        cmd.Parameters.Add("@userName", SqlDbType.VarChar, 50).Value = FormView1.DataKey["userName"];
        cmd.Parameters.Add("@firstName", SqlDbType.VarChar, 50).Value = ((TextBox)(FormView1.FindControl("TextBox1"))).Text;
        cmd.Parameters.Add("@lastName", SqlDbType.VarChar, 50).Value = ((TextBox)(FormView1.FindControl("TextBox2"))).Text;
        cmd.Parameters.Add("@userGender", SqlDbType.VarChar, 50).Value = (((DropDownList)(FormView1.FindControl("DropDownList1"))).SelectedValue).ToString();
        cmd.Parameters.Add("@contactNumber", SqlDbType.BigInt).Value = Convert.ToInt64(((TextBox)(FormView1.FindControl("TextBox3"))).Text);
        cmd.Parameters.Add("@userAddress", SqlDbType.NVarChar, 50).Value = ((TextBox)(FormView1.FindControl("TextBox4"))).Text;
        cmd.Parameters.Add("@userCountry", SqlDbType.VarChar, 50).Value = dl1.SelectedValue;
        cmd.Parameters.Add("@userState", SqlDbType.VarChar, 50).Value = dl2.SelectedValue;
        cmd.Parameters.Add("@userCity", SqlDbType.VarChar, 50).Value = dl3.SelectedValue;
        cmd.Parameters.Add("@postalCode", SqlDbType.Int).Value = Convert.ToInt32(((TextBox)(FormView1.FindControl("TextBox5"))).Text);

        cmd.ExecuteNonQuery();
        cmd.Dispose();
        con.Close();
        FormView1.ChangeMode(FormViewMode.ReadOnly);
        bind();
    }
    protected void FormView1_ItemInserting(object sender, FormViewInsertEventArgs e)
    {
        UpdatePanel up4 = (UpdatePanel)(FormView1.FindControl("UpdatePanel4"));
        DropDownList dl1 = (DropDownList)(up4.FindControl("DropDownList6"));

        UpdatePanel up5 = (UpdatePanel)(up4.FindControl("UpdatePanel5"));
        DropDownList dl2 = (DropDownList)(up5.FindControl("DropDownList7"));

        UpdatePanel up6 = (UpdatePanel)(up5.FindControl("UpdatePanel6"));
        DropDownList dl3 = (DropDownList)(up6.FindControl("DropDownList8"));

        string q = "insert into user_Info (userName, firstName, lastName,userGender,contactNumber, userAddress, userCountry, userState, userCity, postalCode) values (@userName, @firstName, @lastName, @userGender,@contactNumber, @userAddress, @userCountry, @userState, @userCity, @postalCode)";
        SqlCommand cmd = new SqlCommand(q, con);

        cmd.Parameters.Add("@userName", SqlDbType.VarChar, 50).Value = Label3.Text;
        cmd.Parameters.Add("@firstName", SqlDbType.VarChar, 50).Value = ((TextBox)(FormView1.FindControl("TextBox6"))).Text;
        cmd.Parameters.Add("@lastName", SqlDbType.VarChar, 50).Value = ((TextBox)(FormView1.FindControl("TextBox7"))).Text;
        cmd.Parameters.Add("@userGender", SqlDbType.VarChar, 50).Value = (((DropDownList)(FormView1.FindControl("DropDownList5"))).SelectedValue).ToString();
        cmd.Parameters.Add("@contactNumber", SqlDbType.BigInt).Value = Convert.ToInt64(((TextBox)(FormView1.FindControl("TextBox8"))).Text);
        cmd.Parameters.Add("@userAddress", SqlDbType.NVarChar, 50).Value = ((TextBox)(FormView1.FindControl("TextBox9"))).Text;
        cmd.Parameters.Add("@userCountry", SqlDbType.VarChar, 50).Value = dl1.SelectedValue;
        cmd.Parameters.Add("@userState", SqlDbType.VarChar, 50).Value = dl2.SelectedValue;
        cmd.Parameters.Add("@userCity", SqlDbType.VarChar, 50).Value = dl3.SelectedValue;
        cmd.Parameters.Add("@postalCode", SqlDbType.Int).Value = Convert.ToInt32(((TextBox)(FormView1.FindControl("TextBox10"))).Text);

        cmd.ExecuteNonQuery();
        cmd.Dispose();
        con.Close();
        FormView1.ChangeMode(FormViewMode.ReadOnly);
        bind();
    }
    protected void DropDownList6_SelectedIndexChanged(object sender, EventArgs e)
    {
        SqlDataSource5.SelectParameters["country"].DefaultValue = DropDownList6.SelectedValue;
    }
    protected void DropDownList7_SelectedIndexChanged(object sender, EventArgs e)
    {
        SqlDataSource6.SelectParameters["state"].DefaultValue = DropDownList7.SelectedValue;
    }
    protected void DropDownList8_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
    protected void DropDownList9_SelectedIndexChanged(object sender, EventArgs e)
    {
        SqlDataSource12.SelectParameters["country"].DefaultValue = DropDownList9.SelectedValue;
    }
    protected void DropDownList10_SelectedIndexChanged(object sender, EventArgs e)
    {
        SqlDataSource13.SelectParameters["state"].DefaultValue = DropDownList10.SelectedValue;
    }
    protected void DropDownList11_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
}