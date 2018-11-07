<%@ Page Title="" Language="C#" MasterPageFile="~/musicvalley.master" AutoEventWireup="true" CodeFile="register.aspx.cs" Inherits="Default2" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table style="width: 100%; height: 706px;">
    <tr>
        <td style="height: 46px; text-align: center;">
            <div style="font-family: Calibri; font-size: large; color: #FFFFFF; background-color: #000000; border: thin #FFFFFF dotted">
                <strong>&lt;&lt;
                CREATE NEW USER &gt;&gt;</strong></div>
        </td>
    </tr>
    <tr>
        <td> 
            <div style="border: thin #000000 dotted; font: medium serif; height: 649px; background-image: url('WebImages/signback.png'); text-align: center; text-transform: uppercase; font-family: Calibri; font-size: medium; font-weight: bold;">
                <asp:CreateUserWizard ID="CreateUserWizard1" runat="server" 
                    CancelDestinationPageUrl="~/home.aspx" 
                    ContinueDestinationPageUrl="~/userinfo.aspx">
                    <WizardSteps>
                        <asp:CreateUserWizardStep ID="CreateUserWizardStep1" runat="server" />
                        <asp:CompleteWizardStep ID="CompleteWizardStep1" runat="server" />
                    </WizardSteps>
                </asp:CreateUserWizard>
            </div>
        </td>
    </tr>
</table>
</asp:Content>

