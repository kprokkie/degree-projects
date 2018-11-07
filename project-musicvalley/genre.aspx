<%@ Page Title="" Language="C#" MasterPageFile="~/Admin.master" AutoEventWireup="true" CodeFile="genre.aspx.cs" Inherits="Default3" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table style="width: 100%; height: 693px;">
        <tr>
            <td>
                <div style="height: 687px">
                    <table style="width: 100%; height: 687px;">
                        <tr>
                            <td class="style43" 
                                style="border: thin #000000 dotted; height: 53px; text-align: center; text-transform: uppercase;">
                                <div>
                                    <b><span style="font-family: Calibri; font-size: large; color: #FF0000">&lt;&lt;</span><span 
                                        style="font-family: Calibri; font-size: large; color: #0000FF">
                                    MODIFY
                                    </span></b>
                                    <asp:Label ID="Label3" runat="server" 
                                        
                                        style="font-family: Calibri; font-weight: bold; font-size: large; color: #0000FF;" 
                                        Text="Label"></asp:Label>
                                    <b><span style="font-family: Calibri; font-size: large; color: #0000FF">&nbsp;GENRE</span><span 
                                        style="font-family: Calibri; font-size: large; color: #FF0000"> &gt;&gt;</span></b></div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div style="font: medium Calibri; border: thin #000000 dotted; height: 627px; color: #6666FF; text-transform: uppercase; text-align: center;">
                                    <asp:GridView ID="GridView1" runat="server" BackColor="White" 
                                        BorderColor="#CCCCCC" BorderStyle="None" BorderWidth="1px" CellPadding="4" 
                                        AutoGenerateColumns="False" PageSize="3" DataKeyNames="proID" 
                                        onpageindexchanging="GridView1_PageIndexChanging" 
                                        onrowcancelingedit="GridView1_RowCancelingEdit" 
                                         onrowdeleting="GridView1_RowDeleting" 
                                        onrowediting="GridView1_RowEditing" onrowupdating="GridView1_RowUpdating" 
                                        AllowPaging="True" GridLines="Horizontal" ForeColor="Black" 
                                        onselectedindexchanged="GridView1_SelectedIndexChanged">
                                        <%--<PagerStyle BackColor="#666666" ForeColor="White" HorizontalAlign="Center" />
            <SelectedRowStyle BackColor="#C5BBAF" Font-Bold="True" ForeColor="#333333" />
            <HeaderStyle BackColor="#1C5E55" Font-Bold="True" ForeColor="White" />--%>
                                        <SortedAscendingCellStyle BackColor="#F4F4FD">
                                        </SortedAscendingCellStyle>
                                        <SortedAscendingHeaderStyle BackColor="#5A4C9D">
                                        </SortedAscendingHeaderStyle>
                                        <SortedDescendingCellStyle BackColor="#D8D8F0">
                                        </SortedDescendingCellStyle>
                                        <SortedDescendingHeaderStyle BackColor="#3E3277">
                                        </SortedDescendingHeaderStyle>
                                        <Columns>
                                            <asp:TemplateField HeaderText="Product Image">
                                                <ItemTemplate>
                                                    <asp:Image ID="Image1" runat="server" ImageUrl='<%# Eval("proImage","~/ProductImages/{0}") %>' 
                                                Height="145px" Width="120px" BorderStyle="Outset">
                                                    </asp:Image>
                                                </ItemTemplate>
                                            </asp:TemplateField>
                                            <asp:TemplateField HeaderText="Product Detail">
                                                <ItemTemplate>
                                                    <table style="width:100%;">
                                                        <tr>
                                                            <td>
                                                                <b>Album </b>
                                                            </td>
                                                            <td>
                                                                &nbsp;<%#Eval("proName")%></td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <b>Artist</b></td>
                                                            <td>
                                                                &nbsp;<%#Eval("proDetail")%></td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <b>Price </b>
                                                            </td>
                                                            <td>
                                                                &nbsp;<%#Eval("proPrice")%></td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <b>Category </b>
                                                            </td>
                                                            <td>
                                                                &nbsp;<%#Eval("proCategory")%></td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <b>Rating </b>
                                                            </td>
                                                            <td>
                                                                &nbsp;<%#Eval("proRating")%></td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <asp:LinkButton ID="LinkButton1" runat="server" CommandName="edit">Edit</asp:LinkButton>
                                                            </td>
                                                            <td>
                                                                <asp:LinkButton ID="LinkButton2" runat="server" CommandName="delete">Delete</asp:LinkButton>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </ItemTemplate>
                                                <EditItemTemplate>
                                                    <table style="width:100%;">
                                                        <tr>
                                                            <td>
                                                                <b>Album :</b></td>
                                                            <td>
                                                                <asp:TextBox ID="TextBox1" runat="server" Text='<%#Eval("proName")%>' 
                                                                    Height="22px" Width="100px"></asp:TextBox>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <b>Artist : </b>
                                                            </td>
                                                            <td>
                                                                <asp:TextBox ID="TextBox2" runat="server" Text='<%#Eval("proDetail")%>' 
                                                                    Width="100px"></asp:TextBox>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <b>Price :</b></td>
                                                            <td>
                                                                <asp:TextBox ID="TextBox3" runat="server" Text='<%#Eval("proPrice")%>' 
                                                                    Width="100px"></asp:TextBox>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <b>Category :</b></td>
                                                            <td>
                                                                <b>
                                                                <asp:DropDownList ID="DropDownList1" runat="server" Height="22px" Width="100px">
                                                                    <asp:ListItem>pop</asp:ListItem>
                                                                    <asp:ListItem>jazz</asp:ListItem>
                                                                    <asp:ListItem>hiphop</asp:ListItem>
                                                                    <asp:ListItem>contempory</asp:ListItem>
                                                                    <asp:ListItem>rock</asp:ListItem>
                                                                    <asp:ListItem>classical</asp:ListItem>
                                                                    <asp:ListItem>raggae</asp:ListItem>
                                                                    <asp:ListItem>country</asp:ListItem>
                                                                    <asp:ListItem>dance</asp:ListItem>
                                                                    <asp:ListItem>game</asp:ListItem>
                                                                </asp:DropDownList>
                                                                </b>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <b>Rating :</b><%#Eval("proRating")%></td>
                                                            <td>
                                                                <b>
                                                                <asp:DropDownList ID="DropDownList2" runat="server" Height="22px" Width="100px">
                                                                    <asp:ListItem>1</asp:ListItem>
                                                                    <asp:ListItem>2</asp:ListItem>
                                                                    <asp:ListItem>3</asp:ListItem>
                                                                    <asp:ListItem>4</asp:ListItem>
                                                                    <asp:ListItem>5</asp:ListItem>
                                                                </asp:DropDownList>
                                                                </b>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <b>
                                                                <asp:LinkButton ID="LinkButton3" runat="server" CommandName="update">Update</asp:LinkButton>
                                                                </b>
                                                            </td>
                                                            <td>
                                                                <b>
                                                                <asp:LinkButton ID="LinkButton4" runat="server" CommandName="cancel">Cancel</asp:LinkButton>
                                                                </b>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </EditItemTemplate>
                                            </asp:TemplateField>
                                        </Columns>
                                        <EmptyDataTemplate>
                                            NO PRODUCT FOUND
                                        </EmptyDataTemplate>
                                        <FooterStyle BackColor="#CCCC99" ForeColor="Black" />
                                        <HeaderStyle BackColor="#333333" Font-Bold="True" ForeColor="White" />
                                        <PagerStyle BackColor="White" ForeColor="Black" HorizontalAlign="Right" />
                                        <SelectedRowStyle BackColor="#CC3333" Font-Bold="True" ForeColor="White" />
                                        <SortedAscendingCellStyle BackColor="#F7F7F7" />
                                        <SortedAscendingHeaderStyle BackColor="#4B4B4B" />
                                        <SortedDescendingCellStyle BackColor="#E5E5E5" />
                                        <SortedDescendingHeaderStyle BackColor="#242121" />
                                    </asp:GridView>
                                    <br />
                                    <asp:HyperLink ID="HyperLink19" runat="server" NavigateUrl="~/admin.aspx" 
                                        style="font-weight: 700; color: #FF0000">&lt;&lt; BACK TO MENU</asp:HyperLink>
                                    <br />
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </td>
        </tr>
    </table>
</asp:Content>

