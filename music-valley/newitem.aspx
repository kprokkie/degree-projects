<%@ Page Title="" Language="C#" MasterPageFile="~/Admin.master" AutoEventWireup="true" CodeFile="newitem.aspx.cs" Inherits="Default3" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table style="width: 100%; height: 694px;">
        <tr>
            <td>
                <div style="height: 688px">
                    <table style="width: 100%; height: 689px;">
                        <tr>
                            <td style="border: thin #000000 dotted; height: 48px">
                                <div style="font-weight: 700; color: #0000FF; font-family: Calibri; font-size: large; text-transform: uppercase; text-align: center">
                                    <span style="color: #FF0000">&lt;&lt;</span>
                                    CREATE NEW PRODUCT WIZARD <span style="color: #FF0000">&gt;&gt;</span></div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div style="border: thin #000000 dotted; height: 636px; text-transform: uppercase; font-family: Calibri; font-size: medium;">
                                    <table style="width:100%;">
                                        <tr>
                                            <td>
                                                <asp:TextBox ID="TextBox9" runat="server" Visible="False"></asp:TextBox>
                                            </td>
                                            <td>
                                                Product Image</td>
                                            <td>
                                                <asp:FileUpload ID="FileUpload1" runat="server" EnableTheming="False" />
                                                <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" 
                                                    ControlToValidate="FileUpload1" ErrorMessage="* Browse " SetFocusOnError="True" 
                                                    ValidationGroup="n"></asp:RequiredFieldValidator>
                                            </td>
                                            <td>
                                                <asp:TextBox ID="TextBox2" runat="server" Visible="False"></asp:TextBox>
                                                <asp:TextBox ID="TextBox8" runat="server" Visible="False"></asp:TextBox>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                &nbsp;</td>
                                            <td>
                                                Product ID</td>
                                            <td>
                                                <asp:TextBox ID="TextBox3" runat="server" ReadOnly="True" ValidationGroup="n"></asp:TextBox>
                                                <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" 
                                                    ControlToValidate="TextBox3" ErrorMessage="RequiredFieldValidator" 
                                                    ValidationGroup="n"></asp:RequiredFieldValidator>
                                            </td>
                                            <td rowspan="7">
                                                <div style="height: 203px">
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                &nbsp;</td>
                                            <td>
                                                Product Name</td>
                                            <td>
                                                <asp:TextBox ID="TextBox4" runat="server" ValidationGroup="n"></asp:TextBox>
                                                <asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" 
                                                    ControlToValidate="TextBox4" ErrorMessage="* Missing" SetFocusOnError="True" 
                                                    ValidationGroup="n"></asp:RequiredFieldValidator>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                &nbsp;</td>
                                            <td>
                                                Product Artist</td>
                                            <td>
                                                <asp:TextBox ID="TextBox5" runat="server" ValidationGroup="n"></asp:TextBox>
                                                <asp:RequiredFieldValidator ID="RequiredFieldValidator5" runat="server" 
                                                    ControlToValidate="TextBox5" ErrorMessage="* Missing" SetFocusOnError="True" 
                                                    ValidationGroup="n"></asp:RequiredFieldValidator>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                &nbsp;</td>
                                            <td>
                                                Product Price</td>
                                            <td>
                                                <asp:TextBox ID="TextBox6" runat="server" ValidationGroup="n"></asp:TextBox>
                                                <asp:RequiredFieldValidator ID="RequiredFieldValidator6" runat="server" 
                                                    ControlToValidate="TextBox6" ErrorMessage="* Missing" SetFocusOnError="True" 
                                                    ValidationGroup="n"></asp:RequiredFieldValidator>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                &nbsp;</td>
                                            <td>
                                                Product Genre</td>
                                            <td>
                                                <asp:DropDownList ID="DropDownList1" runat="server" Height="22px" 
                                                    ValidationGroup="n" Width="128px">
                                                    <asp:ListItem>classical</asp:ListItem>
                                                    <asp:ListItem>contemp</asp:ListItem>
                                                    <asp:ListItem>country</asp:ListItem>
                                                    <asp:ListItem>dance</asp:ListItem>
                                                    <asp:ListItem>game</asp:ListItem>
                                                    <asp:ListItem>hiphop</asp:ListItem>
                                                    <asp:ListItem>jazz</asp:ListItem>
                                                    <asp:ListItem>pop</asp:ListItem>
                                                    <asp:ListItem>raggae</asp:ListItem>
                                                    <asp:ListItem>rock</asp:ListItem>
                                                </asp:DropDownList>
                                                <asp:RequiredFieldValidator ID="RequiredFieldValidator7" runat="server" 
                                                    ControlToValidate="DropDownList1" ErrorMessage="RequiredFieldValidator" 
                                                    ValidationGroup="n"></asp:RequiredFieldValidator>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                &nbsp;</td>
                                            <td>
                                                Product Rating</td>
                                            <td>
                                                <asp:DropDownList ID="DropDownList2" runat="server" Height="22px" 
                                                    ValidationGroup="n" Width="128px">
                                                    <asp:ListItem>1</asp:ListItem>
                                                    <asp:ListItem>2</asp:ListItem>
                                                    <asp:ListItem>3</asp:ListItem>
                                                    <asp:ListItem>4</asp:ListItem>
                                                    <asp:ListItem>5</asp:ListItem>
                                                </asp:DropDownList>
                                                <asp:RequiredFieldValidator ID="RequiredFieldValidator8" runat="server" 
                                                    ControlToValidate="DropDownList2" ErrorMessage="RequiredFieldValidator" 
                                                    ValidationGroup="n"></asp:RequiredFieldValidator>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                &nbsp;</td>
                                            <td>
                                                Product Date</td>
                                            <td>
                                                <asp:TextBox ID="TextBox7" runat="server" ReadOnly="True" ValidationGroup="n"></asp:TextBox>
                                                <asp:RequiredFieldValidator ID="RequiredFieldValidator9" runat="server" 
                                                    ControlToValidate="TextBox7" ErrorMessage="RequiredFieldValidator" 
                                                    ValidationGroup="n"></asp:RequiredFieldValidator>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">
                                                &nbsp;</td>
                                            <td>
                                                &nbsp;</td>
                                            <td>
                                                &nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">
&nbsp;</td>
                                            <td colspan="2">
                                                <asp:Button ID="Button2" runat="server" onclick="Button2_Click" 
                                                    Text="ADD NEW PRODUCT" ValidationGroup="n" Width="180px" 
                                                    style="font-weight: 700; font-family: Calibri; color: #0000FF; font-size: medium" />
                                                <asp:Label ID="Label3" runat="server" style="color: #FF0066" Text="Label"></asp:Label>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">
                                                &nbsp;</td>
                                            <td>
                                                &nbsp;</td>
                                            <td>
                                                &nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">
                                                &nbsp;</td>
                                            <td>
                                                &nbsp;&nbsp;<asp:HyperLink ID="HyperLink18" runat="server" 
                                                    NavigateUrl="~/admin.aspx" style="font-weight: 700; color: #FF0000">&lt;&lt; BACK TO MENU</asp:HyperLink>
                                            </td>
                                            <td>
                                                &nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">
                                                &nbsp;</td>
                                            <td>
                                                &nbsp;</td>
                                            <td>
                                                &nbsp;</td>
                                        </tr>
                                    </table>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </td>
        </tr>
    </table>
</asp:Content>

