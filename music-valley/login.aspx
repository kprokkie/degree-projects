<%@ Page Title="" Language="C#" MasterPageFile="~/musicvalley.master" AutoEventWireup="true" CodeFile="login.aspx.cs" Inherits="Default2" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table style="width: 100%; height: 694px;">
    <tr>
        <td class="style11" style="height: 52px">
            <div style="font-family: Calibri; font-size: large; color: #FFFFFF; border: thin #FFFFFF dotted; background-color: #000000; text-align: center">
                <strong>&lt;&lt;
                LOGIN
                &gt;&gt;</strong></div> 
        </td>
    </tr> 
    <tr>
        <td>
            <div style="border: thin #000000 dotted; height: 632px; background-image: url('WebImages/no_admin.jpg'); text-align: center; text-transform: uppercase;">
                <asp:Login ID="Login1" runat="server" CreateUserText="CREATE NEW ACCOUNT" 
                    CreateUserUrl="~/register.aspx" 
                    DestinationPageUrl="~/home.aspx" Height="154px" Font-Bold="True" 
                    Font-Names="Calibri" Font-Size="Large">
                </asp:Login>
            </div>
        </td>
    </tr>
</table>
</asp:Content>

