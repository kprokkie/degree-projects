<%@ Page Title="" Language="C#" MasterPageFile="~/Admin.master" AutoEventWireup="true" CodeFile="category.aspx.cs" Inherits="Default3" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table style="width: 100%; height: 694px;">
        <tr>
            <td>
                <div style="height: 688px">
                    <table style="width: 100%; height: 689px;">
                        <tr>
                            <td style="height: 51px">
                                <div style="border: thin #000000 dotted; font-family: Calibri; font-size: large; text-align: center; text-transform: uppercase;">
                                    <strong>&nbsp;<span style="color: #FF0000">&lt;&lt;</span>
                                    <span style="color: #0000FF">PRODUCTS</span> <span style="color: #FF0000">&gt;&gt;</span></strong></div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div style="border: thin #000000 dotted; height: 630px; text-align: center;">
                                    <table style="width: 100%; height: 632px;">
                                        <tr>
                                            <td>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <asp:ImageButton ID="ImageButton1" runat="server" Height="116px" 
                                                ImageUrl="~/WebImages/contempory.jpg" onclick="ImageButton1_Click" 
                                                Width="120px" BorderStyle="Dotted" BorderWidth="1px" />
                                            </td>
                                            <td>
                                                <div>
&nbsp;<img alt="" src="WebImages/arr.jpg" /><span style="font-family: Calibri; font-size: large"><strong>CONTEMPORY</strong></span></div>
                                            </td>
                                            <td>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <asp:ImageButton ID="ImageButton2" runat="server" Height="116px" 
                                                ImageUrl="~/WebImages/country.jpg" onclick="ImageButton2_Click" Width="120px" 
                                                    BorderStyle="Dotted" BorderWidth="1px" />
                                            </td>
                                            <td>
                                                <div>
                                                    <img alt="" src="WebImages/arr.jpg" /><span 
                                                    style="font-family: Calibri; font-size: large"><strong>COUNTRY</strong></span></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <div>
                                                    <span style="font-family: Calibri"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                                                CLASSICAL</strong></span><img alt="" src="WebImages/all.jpg" /></div>
                                            </td>
                                            <td>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <asp:ImageButton ID="ImageButton3" runat="server" Height="116px" 
                                                ImageUrl="~/WebImages/classical.jpg" onclick="ImageButton3_Click" 
                                                Width="120px" BorderStyle="Dotted" BorderWidth="1px" />
                                            </td>
                                            <td>
                                                <div>
                                                    <span style="font-family: Calibri"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                                                JAZZ</strong></span><img alt="" src="WebImages/all.jpg" /></div>
                                            </td>
                                            <td>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <asp:ImageButton ID="ImageButton4" runat="server" Height="116px" 
                                                ImageUrl="~/WebImages/jazz.jpg" onclick="ImageButton4_Click" Width="120px" 
                                                    BorderStyle="Dotted" BorderWidth="1px" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <asp:ImageButton ID="ImageButton5" runat="server" Height="116px" 
                                                ImageUrl="~/WebImages/hip hop.jpg" onclick="ImageButton5_Click" Width="120px" 
                                                    BorderStyle="Dotted" BorderWidth="1px" />
                                            </td>
                                            <td>
                                                <div>
                                                    <img alt="" src="WebImages/arr.jpg" /><span 
                                                    style="font-family: Calibri; font-size: large"><strong>HIP HOP</strong></span></div>
                                            </td>
                                            <td>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <asp:ImageButton ID="ImageButton6" runat="server" Height="116px" 
                                                ImageUrl="~/WebImages/pop.jpg" onclick="ImageButton6_Click" Width="120px" 
                                                    BorderStyle="Dotted" BorderWidth="1px" />
                                            </td>
                                            <td>
                                                <div>
                                                    <img alt="" src="WebImages/arr.jpg" /><span 
                                                    style="font-family: Calibri; font-size: large"><strong>POP</strong></span></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <div>
                                                    <span style="font-family: Calibri; font-size: large"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                                                REGGAE</strong></span><img alt="" src="WebImages/all.jpg" /></div>
                                            </td>
                                            <td>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <asp:ImageButton ID="ImageButton7" runat="server" Height="116px" 
                                                ImageUrl="~/WebImages/reggae.jpg" onclick="ImageButton7_Click" Width="120px" 
                                                    BorderStyle="Dotted" BorderWidth="1px" />
                                            </td>
                                            <td>
                                                <div>
                                                    <span style="font-family: Calibri; font-size: large"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                                                ROCK</strong></span><img alt="" src="WebImages/all.jpg" /></div>
                                            </td>
                                            <td>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <asp:ImageButton ID="ImageButton8" runat="server" Height="116px" 
                                                ImageUrl="~/WebImages/rock1.jpg" onclick="ImageButton8_Click" Width="120px" 
                                                    BorderStyle="Dotted" BorderWidth="1px" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <asp:ImageButton ID="ImageButton9" runat="server" Height="116px" 
                                                ImageUrl="~/WebImages/dance.jpg" onclick="ImageButton9_Click" Width="120px" 
                                                    BorderStyle="Dotted" BorderWidth="1px" />
                                            </td>
                                            <td>
                                                <div>
                                                    <img alt="" src="WebImages/arr.jpg" /><span 
                                                    style="font-family: Calibri; font-size: large"><strong>DANCE</strong></span></div>
                                            </td>
                                            <td>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <asp:ImageButton ID="ImageButton10" runat="server" Height="116px" 
                                                ImageUrl="~/WebImages/game.jpg" onclick="ImageButton10_Click" Width="120px" 
                                                    BorderStyle="Dotted" BorderWidth="1px" />
                                            </td>
                                            <td>
                                                <div>
                                                    <img alt="" src="WebImages/arr.jpg" /><span 
                                                    style="font-family: Calibri; font-size: large"><strong>GAME</strong></span></div>
                                            </td>
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

