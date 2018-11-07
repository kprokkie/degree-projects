<%@ Page Title="" Language="C#" MasterPageFile="~/musicvalley.master" AutoEventWireup="true" CodeFile="home.aspx.cs" Inherits="Default2" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table style="width: 100%; height: 706px;">
        <tr>
            <td> 
                <div style="height: 700px">
                    <table style="width: 100%; height: 701px;">
                        <tr>
                            <td style="border: thin #000000 dotted; height: 43px; text-align: center; text-transform: uppercase;">
                                <div>
                                    &nbsp;<span style="font-family: Calibri; font-size: large"><strong>
                                    <span style="color: #FF0000">&lt;&lt;</span> </strong></span>
                                    <span style="color: #0066FF; font-family: Calibri; font-size: large;"><strong>Welcome</strong></span> 
                                    <strong> <asp:LoginName ID="LoginName1" 
                                        runat="server" ForeColor="Fuchsia" 
                                        style="color: #33CC33; font-family: Calibri; font-size: large;" />
                                    </strong>
                                    <span style="color: #0066FF; font-family: Calibri; font-size: large;"><strong>to the Music World</strong></span><span 
                                        style="font-family: Calibri; font-size: large"><strong>
                                    <span style="color: #FF0000">&gt;&gt;</span></strong></span>&nbsp;</div>
                            </td>
                        </tr> 
                        <tr>
                            <td style="height: 591px">
                                <div style="font: small Calibri; border: thin dotted #999999; height: 642px; text-align: center; background-image: url('WebImages/best-abstract-wallpaper-ever.jpg'); text-transform: uppercase;">
                                    <asp:ListView ID="ListView1" runat="server" DataKeyNames="proID" 
                                        DataSourceID="SqlDataSource1" GroupItemCount="4" 
                                        onitemcommand="ListView1_ItemCommand" 
                                          >
                                         <%--onselectedindexchanged="ListView1_SelectedIndexChanged"--%> 
                                       <%--onitemcommand="ListView1_ItemCommand"--%>
                                        <AlternatingItemTemplate>
                                            <td runat="server" style="background-color: #FFFFFF;color: #284775;">
                                                <br />
                                                &nbsp;&nbsp;
                                                <asp:Image ID="Image5" runat="server" ImageUrl='<%# Eval("proImage","~/ProductImages/{0}") %>' Height="180px" Width="160px" BorderStyle="Outset" />
                                                &nbsp;&nbsp;&nbsp;&nbsp;
                                           
                                                <%--proID:--%>
                                                <asp:Label ID="proIDLabel" runat="server" Text='<%# Eval("proID") %>'  Visible="False" />
                                                <%--<br />
                                                proImage:
                                                <asp:Label ID="proImageLabel" runat="server" Text='<%# Eval("proImage") %>' />
                                                <br />--%>
                                                <%--proName:--%>
                                                <asp:Label ID="proNameLabel" runat="server" Text='<%# Eval("proName") %>' ForeColor="Blue" />
                                                <br />
                                                <%--proDetail:--%>
                                                by&nbsp;<asp:Label ID="proDetailLabel" runat="server" Text='<%# Eval("proDetail") %>' ForeColor="Red" />
                                                <br />
                                                <%--proPrice:--%>
                                                price&nbsp;$<asp:Label ID="proPriceLabel" runat="server" Text='<%# Eval("proPrice") %>' />
                                                <br />
                                                 <asp:Button ID="Button1" runat="server" Text="ADD TO CART"  Font-Bold="False" Font-Overline="False" 
                                                  Font-Size="Small" ForeColor="White" BackColor="Black" Font-Names="calibri" Width="90" Height="25"  CommandName="add" />
                                                 <br /> <br /><%--OnClick="Button1_Click" CommandName="select" --%>
                                            </td>
                                        </AlternatingItemTemplate>
                                        <EditItemTemplate>
                                            <td runat="server" style="background-color: #999999;">
                                                proID:
                                                <asp:Label ID="proIDLabel1" runat="server" Text='<%# Eval("proID") %>' />
                                                <br />proImage:
                                                <asp:TextBox ID="proImageTextBox" runat="server" 
                                                    Text='<%# Bind("proImage") %>' />
                                                <br />proName:
                                                <asp:TextBox ID="proNameTextBox" runat="server" Text='<%# Bind("proName") %>' />
                                                <br />proPrice:
                                                <asp:TextBox ID="proPriceTextBox" runat="server" 
                                                    Text='<%# Bind("proPrice") %>' />
                                                <br />proDetail:
                                                <asp:TextBox ID="proDetailTextBox" runat="server" 
                                                    Text='<%# Bind("proDetail") %>' />
                                                <br />
                                                <asp:Button ID="UpdateButton" runat="server" CommandName="Update" 
                                                    Text="Update" />
                                                <br />
                                                <asp:Button ID="CancelButton" runat="server" CommandName="Cancel" 
                                                    Text="Cancel" />
                                                <br />
                                            </td>
                                        </EditItemTemplate>
                                        <EmptyDataTemplate>
                                            <table runat="server" 
                                                style="background-color: #FFFFFF;border-collapse: collapse;border-color: #999999;border-style:none;border-width:1px;">
                                                <tr>
                                                    <td>
                                                        No data was returned.</td>
                                                </tr>
                                            </table>
                                        </EmptyDataTemplate>
                                        <EmptyItemTemplate>
<td runat="server" />
                                        </EmptyItemTemplate>
                                        <GroupTemplate>
                                            <tr ID="itemPlaceholderContainer" runat="server">
                                                <td ID="itemPlaceholder" runat="server">
                                                </td>
                                            </tr>
                                        </GroupTemplate>
                                        <InsertItemTemplate>
                                            <td runat="server" style="">
                                                proID:
                                                <asp:TextBox ID="proIDTextBox" runat="server" Text='<%# Bind("proID") %>' />
                                                <br />proImage:
                                                <asp:TextBox ID="proImageTextBox0" runat="server" 
                                                    Text='<%# Bind("proImage") %>' />
                                                <br />proName:
                                                <asp:TextBox ID="proNameTextBox0" runat="server" 
                                                    Text='<%# Bind("proName") %>' />
                                                <br />proPrice:
                                                <asp:TextBox ID="proPriceTextBox0" runat="server" 
                                                    Text='<%# Bind("proPrice") %>' />
                                                <br />proDetail:
                                                <asp:TextBox ID="proDetailTextBox0" runat="server" 
                                                    Text='<%# Bind("proDetail") %>' />
                                                <br />
                                                <asp:Button ID="InsertButton" runat="server" CommandName="Insert" 
                                                    Text="Insert" />
                                                <br />
                                                <asp:Button ID="CancelButton0" runat="server" CommandName="Cancel" 
                                                    Text="Clear" />
                                                <br />
                                            </td>
                                        </InsertItemTemplate>
                                        <ItemTemplate>
                                            <td runat="server" style="background-color: #E0FFFF;color: #333333;">
                                                <br />
                                                &nbsp;&nbsp;
                                                <asp:Image ID="Image6" runat="server" 
                                                    ImageUrl='<%# Eval("proImage","~/ProductImages/{0}") %>' Height="180px" 
                                                    Width="160px" ImageAlign="AbsMiddle" BorderStyle="Outset" />
                                                &nbsp;&nbsp;&nbsp;&nbsp;
                                        
                                                <%--proID:--%>
                                                <asp:Label ID="proIDLabel" runat="server" Text='<%# Eval("proID") %>' Visible="False" />
                                                <%--<br />
                                                proImage:
                                                <asp:Label ID="proImageLabel" runat="server" Text='<%# Eval("proImage") %>'></asp:Label>
                                                <br />--%>
                                                <%--proName:--%>
                                                <asp:Label ID="proNameLabel" runat="server" Text='<%# Eval("proName") %>' 
                                                    ForeColor="Blue" />
                                                <br />
                                                <%--proDetail:--%>
                                                by&nbsp;<asp:Label ID="proDetailLabel" runat="server" 
                                                    Text='<%# Eval("proDetail") %>' ForeColor="Red" />
                                                <br />
                                                <%--proPrice:--%>
                                                price&nbsp;$<asp:Label ID="proPriceLabel" runat="server" 
                                                    Text='<%# Eval("proPrice") %>' />
                                                <br />
                                                <asp:Button ID="Button1" runat="server" Text="ADD TO CART" Font-Bold="False" 
                                                    Font-Overline="False" Font-Size="Small" ForeColor="White" BackColor="Black" 
                                                    Font-Names="calibri" Width="90" Height="25" CommandName="add"/>
                                                 <br /> <br /><%--OnClick="Button1_Click"  CommandName="select" --%>
                                            </td>
                                        </ItemTemplate>
                                        <LayoutTemplate>
                                            <table runat="server">
                                                <tr runat="server">
                                                    <td runat="server">
                                                        <table ID="groupPlaceholderContainer" runat="server" border="1" 
                                                            style="background-color: #FFFFFF;border-collapse: collapse;border-color: #999999;border-style:none;border-width:1px;font-family: Verdana, Arial, Helvetica, sans-serif;">
                                                            <tr ID="groupPlaceholder" runat="server">
                                                            </tr>
                                                        </table>
                                                    </td>
                                                </tr>
                                                <tr runat="server">
                                                    <td runat="server" 
                                                        style="text-align: center;background-color: #5D7B9D;font-family: Verdana, Arial, Helvetica, sans-serif;color: #FFFFFF">
                                                        <asp:DataPager ID="DataPager1" runat="server" PageSize="8">
                                                            <Fields>
                                                                <asp:NextPreviousPagerField ButtonType="Button" ShowFirstPageButton="True" 
                                                                    ShowNextPageButton="False" ShowPreviousPageButton="False" />
                                                                <asp:NumericPagerField />
                                                                <asp:NextPreviousPagerField ButtonType="Button" ShowLastPageButton="True" 
                                                                    ShowNextPageButton="False" ShowPreviousPageButton="False" />
                                                            </Fields>
                                                        </asp:DataPager>
                                                    </td>
                                                </tr>
                                            </table>
                                        </LayoutTemplate>
                                        <SelectedItemTemplate>
                                            <td runat="server" 
                                                style="background-color: #E2DED6;font-weight: bold;color: #333333;">
                                                proID:
                                                <asp:Label ID="proIDLabel" runat="server" Text='<%# Eval("proID") %>' />
                                                <br />proImage:
                                                <asp:Label ID="proImageLabel" runat="server" Text='<%# Eval("proImage") %>' />
                                                <br />proName:
                                                <asp:Label ID="proNameLabel1" runat="server" Text='<%# Eval("proName") %>' />
                                                <br />proPrice:
                                                <asp:Label ID="proPriceLabel1" runat="server" Text='<%# Eval("proPrice") %>' />
                                                <br />proDetail:
                                                <asp:Label ID="proDetailLabel1" runat="server" 
                                                    Text='<%# Eval("proDetail") %>' />
                                                <br />
                                            </td>
                                        </SelectedItemTemplate>
                                    </asp:ListView>
                                    <asp:SqlDataSource ID="SqlDataSource1" runat="server" 
                                        ConnectionString="<%$ ConnectionStrings:cns1 %>" 
                                        
                                        SelectCommand="SELECT [proID], [proImage], [proName], [proPrice], [proDetail] FROM [product_Detail] ">
                                    </asp:SqlDataSource>
                                </div>
                            </td>
                        </tr>
                        <tr>
                        <%--    <td>
                                &nbsp;</td>--%>
                        </tr>
                    </table>
                </div>
            </td>
        </tr>
    </table>
    <br />
</asp:Content> 

