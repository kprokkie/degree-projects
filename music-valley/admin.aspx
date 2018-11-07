<%@ Page Title="" Language="C#" MasterPageFile="~/Admin.master" AutoEventWireup="true" CodeFile="admin.aspx.cs" Inherits="Default3" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table style="width: 100%; height: 692px;">
    <tr>
        <td>
            <div style="height: 685px">
                <table style="width: 100%; height: 687px;">
                    <tr>
                        <td class="style40" style="height: 44px">
                            <div style="font-size: large; font-family: Calibri; color: #0000FF; text-transform: uppercase; text-align: center; border: thin #000000 dotted">
                                <strong><span style="color: #FF0000">&lt;&lt; </span>ADMIN HOME
                                <span style="color: #FF0000">&gt;&gt;</span></strong></div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div style="border: thin #000000 dotted; height: 637px; background-image: url('WebImages/adminback4.jpg');">
                                <table style="width: 100%; height: 639px;">
                                    <tr>
                                        <td>
                                            &nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <img alt="" height="100" src="WebImages/adminicon.png" width="100" /><asp:LinkButton 
                                                ID="LinkButton18" runat="server" onclick="LinkButton18_Click" 
                                                style="font-family: Calibri; font-weight: 700; color: #FF0000; font-size: large">MODIFY PRODUCTS</asp:LinkButton>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            &nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <img alt="" height="100" src="WebImages/adminicon.png" width="100" /><asp:LinkButton 
                                                ID="LinkButton19" runat="server" onclick="LinkButton19_Click" 
                                                style="font-family: Calibri; font-weight: 700; color: #FF0000; font-size: large">MODIFY GENERS</asp:LinkButton>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            &nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <img alt="" height="100" src="WebImages/adminicon.png" width="100" /><asp:LinkButton 
                                                ID="LinkButton20" runat="server" onclick="LinkButton20_Click" 
                                                style="font-family: Calibri; font-weight: 700; color: #FF0000; font-size: large">CREATE PRODUCTS</asp:LinkButton>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            &nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <img alt="" height="100" src="WebImages/adminicon.png" width="100" /><asp:LinkButton 
                                                ID="LinkButton21" runat="server" onclick="LinkButton21_Click" 
                                                style="font-family: Calibri; color: #FF0000; font-weight: 700; font-size: large">MANAGE CART</asp:LinkButton>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            &nbsp;</td>
                                    </tr>
                                    <tr>
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

