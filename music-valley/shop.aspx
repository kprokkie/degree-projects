<%@ Page Title="" Language="C#" MasterPageFile="~/Admin.master" AutoEventWireup="true" CodeFile="shop.aspx.cs" Inherits="Default3" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table style="width: 100%; height: 693px;">
        <tr>
            <td style="font-family: Calibri; font-size: large; background: #FFFFFF; border: thin #000000 dotted; font: normal normal normal 100% serif; height: 53px; text-align: center;">
                <div>
                    &nbsp;<span style="font-family: Calibri; font-size: large"><strong><span 
                        style="color: #FF0000">&lt;&lt;</span> <span style="color: #0000FF">CUSTOMER</span>
                    <span 
                        style="color: #FF0000">&amp; </span><span style="color: #0000FF">SALES </span>
                    <span style="color: #00FF99">TRACK RECORD</span>
                    <span style="color: #FF0000">&gt;&gt;</span></strong></span></div>
            </td>
        </tr>
        <tr>
            <td> 
                <div style="border: thin #000000 dotted; height: 632px">
                    <table style="width: 100%; text-decoration: none">
                        <tr>
                            <td colspan="4">
                                <span style="font-size: large; font-family: Calibri; text-decoration: blink; color: #FF0000;">
                                <strong>SALES OF DAY</strong></span>&nbsp; 
                                <span style="font-family: Calibri; font-size: large"><strong>: $</strong></span> <asp:ListBox ID="ListBox9" 
                                    runat="server" DataSourceID="SqlDataSource7" DataTextField="Expr1" 
                        DataValueField="Expr1" Height="25px" 
                                    
                                    style="border: thin #000000 dotted; font-weight: 700; font-family: Calibri; font-size: large; text-transform: uppercase; color: #0000FF;"></asp:ListBox>
                            </td>
                            <td colspan="3">
                                <span style="font-family: Calibri; font-size: large; text-decoration: blink; color: #FF0000;">
                                <strong>ANNUAL SALES OF YEAR 2011</strong></span>&nbsp;  
                                <span style="font-family: Calibri; font-size: large"><strong>: $</strong></span> <asp:ListBox ID="ListBox6" 
                                    runat="server" DataSourceID="SqlDataSource6" 
                        DataTextField="Expr1" DataValueField="Expr1" Height="25px" 
                                    
                                    style="border: thin #000000 dotted; font-weight: 700; font-family: Calibri; font-size: large; text-transform: uppercase; color: #0000FF;"></asp:ListBox>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="7">
                                &nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="7" style="font-family: Calibri; color: #CC33FF; font-size: large">
                                <asp:ListBox ID="ListBox11" runat="server" DataSourceID="SqlDataSource10" 
                                    DataTextField="Expr1" DataValueField="Expr1" Height="25px" 
                                    style="font-weight: 700; font-family: Calibri; font-size: large; border: thin #000000 dotted; text-decoration: blink; color: #0000FF;" 
                                    Width="25px"></asp:ListBox>
                                <strong>PRODUCTS SOLD TODAY &gt;&gt;</strong></td>
                        </tr>
                        <tr>
                            <td colspan="7">
                                &nbsp;
                                <asp:GridView ID="GridView1" runat="server" AllowPaging="True" 
                                    AutoGenerateColumns="False" BackColor="White" BorderColor="#E7E7FF" 
                                    BorderStyle="None" BorderWidth="1px" CellPadding="3" 
                                    DataSourceID="SqlDataSource8" Font-Bold="True" Font-Names="Calibri" 
                                    GridLines="Horizontal" onselectedindexchanged="GridView1_SelectedIndexChanged" 
                                    PageSize="5" Height="200px" Width="855px">
                                    <AlternatingRowStyle BackColor="#F7F7F7" />
                                    <Columns>
                                        <asp:BoundField DataField="userName" HeaderText="CustomerName" 
                                            SortExpression="userName" />
                                        <asp:BoundField DataField="proName" HeaderText="ProductName" 
                                            SortExpression="proName" />
                                        <asp:BoundField DataField="proDetail" HeaderText="ProductArtist" 
                                            SortExpression="proDetail" />
                                        <asp:BoundField DataField="proPrice" HeaderText="ProductPrice" 
                                            SortExpression="proPrice" />
                                    </Columns>
                                    <FooterStyle BackColor="#B5C7DE" ForeColor="#4A3C8C" />
                                    <HeaderStyle BackColor="#4A3C8C" Font-Bold="True" ForeColor="#F7F7F7" />
                                    <PagerStyle BackColor="#E7E7FF" ForeColor="#4A3C8C" HorizontalAlign="Right" />
                                    <RowStyle BackColor="#E7E7FF" ForeColor="#4A3C8C" />
                                    <SelectedRowStyle BackColor="#738A9C" Font-Bold="True" ForeColor="#F7F7F7" />
                                    <SortedAscendingCellStyle BackColor="#F4F4FD" />
                                    <SortedAscendingHeaderStyle BackColor="#5A4C9D" />
                                    <SortedDescendingCellStyle BackColor="#D8D8F0" />
                                    <SortedDescendingHeaderStyle BackColor="#3E3277" />
                                </asp:GridView>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="7">
                                &nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="3" style="font-family: Calibri; font-size: large; color: #CC33FF">
                                <strong>LIST OF CUSTOMERS &gt;&gt;</strong></td>
                            <td colspan="4">
&nbsp;<span style="font-family: Calibri; font-size: large; color: #CC33FF"><strong>LIST OF PRODUCTS &gt;&gt;</strong></span></td>
                        </tr>
                        <tr>
                            <td rowspan="5">
                                <div style="height: 132px; width: 143px">
                    <asp:ListBox ID="ListBox1" runat="server" DataSourceID="SqlDataSource1" 
                        DataTextField="userName" DataValueField="userName" Height="131px" 
                        Width="142px" AutoPostBack="True" 
                        onselectedindexchanged="ListBox1_SelectedIndexChanged" 
                                        style="font-weight: 700; font-family: Calibri; text-transform: uppercase; text-align: center; border: thin #000000 dotted">
                    </asp:ListBox>
                                </div>
                            </td>
                            <td colspan="2">
                                &nbsp;</td>
                            <td colspan="2" rowspan="5">
                                <div style="height: 128px; width: 139px">
                    <asp:ListBox ID="ListBox2" runat="server" AutoPostBack="True" 
                        DataSourceID="SqlDataSource2" DataTextField="proName" DataValueField="proID" 
                        Height="127px" onselectedindexchanged="ListBox2_SelectedIndexChanged" 
                        Width="139px" 
                                        style="font-weight: 700; font-family: Calibri; text-transform: uppercase; text-align: center; border: thin #000000 dotted"></asp:ListBox>
                                </div>
                            </td>
                            <td colspan="2">
                                &nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="2" style="font-family: Calibri">
                                <strong>CUSTOMER PURCHASES</strong></td>
                            <td colspan="2" style="font-family: Calibri">
                                <strong>PRODUCT SOLDOUT</strong></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <span style="font-family: Calibri; font-size: large"><strong>$ </strong></span>
                                <asp:ListBox ID="ListBox3" runat="server" DataSourceID="SqlDataSource3" 
                        DataTextField="Expr1" DataValueField="Expr1" Height="25px" Width="75px" 
                                    style="font-weight: 700; font-family: Calibri; color: #0000FF; font-size: large; text-transform: uppercase; border: thin #000000 dotted"></asp:ListBox>
                            </td>
                            <td colspan="2">
                    <asp:ListBox ID="ListBox4" runat="server" DataSourceID="SqlDataSource4" 
                        DataTextField="Expr1" DataValueField="Expr1" Height="25px" Width="35px" 
                                    style="font-family: Calibri; font-size: large; color: #0000FF; font-weight: 700; text-transform: uppercase; border: thin #000000 dotted"></asp:ListBox>
                                <span style="font-family: Calibri; font-size: large"><strong>ITEMS</strong></span></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                &nbsp;</td>
                            <td colspan="2">
                                &nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <asp:SqlDataSource ID="SqlDataSource10" runat="server" 
                                    ConnectionString="<%$ ConnectionStrings:cns1 %>" 
                                    SelectCommand="SELECT COUNT(*) AS Expr1 FROM cart_Detail WHERE (DATEPART(d, buyDate) = DATEPART(d, { fn NOW() }))">
                                </asp:SqlDataSource>
                            </td>
                            <td colspan="2">
                                <asp:SqlDataSource ID="SqlDataSource9" runat="server" 
                                    ConnectionString="<%$ ConnectionStrings:cns1 %>" 
                                    SelectCommand="SELECT SUM(proPrice) AS Expr1 FROM cart_Detail WHERE (YEAR(buyDate) = @year) AND (MONTH(buyDate) = @month)">
                                    <SelectParameters>
                                        <asp:ControlParameter ControlID="DropDownList3" Name="year" 
                                            PropertyName="SelectedValue" />
                                        <asp:ControlParameter ControlID="DropDownList2" Name="month" 
                                            PropertyName="SelectedValue" />
                                    </SelectParameters>
                                </asp:SqlDataSource>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="7">
                                &nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="7" style="font-family: Calibri; font-size: large; color: #CC33FF">
                                <strong>SALES TRACK RECORD &gt;&gt;</strong></td>
                        </tr>
                        <tr>
                            <td colspan="7">
                                <span style="font-family: Calibri"><strong>ANNUAL SALES OF YEAR</strong></span>&nbsp;
                    <asp:DropDownList ID="DropDownList1" runat="server" AutoPostBack="True" 
                        onselectedindexchanged="DropDownList1_SelectedIndexChanged" Height="25px" 
                                    style="font-family: Calibri; font-weight: 700; font-size: medium; color: #0000FF" 
                                    Width="60px">
                        <asp:ListItem>2011</asp:ListItem>
                        <asp:ListItem>2010</asp:ListItem>
                        <asp:ListItem>2009</asp:ListItem>
                    </asp:DropDownList>
&nbsp;<span style="font-family: Calibri; font-size: large"><strong>IS</strong></span>
                    <asp:ListBox ID="ListBox5" runat="server" DataSourceID="SqlDataSource5" 
                        DataTextField="Expr1" DataValueField="Expr1" Width="70px" Height="25px" 
                                    style="font-weight: 700; font-family: Calibri; font-size: large; text-transform: uppercase; color: #0000FF; border: thin #000000 dotted"></asp:ListBox>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="7">
                                <span style="font-family: Calibri"><strong>MONTHLY SALES OF</strong></span>
                                <asp:DropDownList ID="DropDownList2" runat="server" AutoPostBack="True" 
                                    Height="25px" 
                                    style="font-weight: 700; font-family: Calibri; font-size: medium; text-transform: uppercase; color: #0000FF;" 
                                    Width="100px">
                                    <asp:ListItem Value="1">january</asp:ListItem>
                                    <asp:ListItem Value="2">feburary</asp:ListItem>
                                    <asp:ListItem Value="3">march</asp:ListItem>
                                    <asp:ListItem Value="4">april</asp:ListItem>
                                    <asp:ListItem Value="5">may</asp:ListItem>
                                    <asp:ListItem Value="6">june</asp:ListItem>
                                    <asp:ListItem Value="7">july</asp:ListItem>
                                    <asp:ListItem Value="8">august</asp:ListItem>
                                    <asp:ListItem Value="9">september</asp:ListItem>
                                    <asp:ListItem Value="10">october</asp:ListItem>
                                    <asp:ListItem Value="11">november</asp:ListItem>
                                    <asp:ListItem Value="12">december</asp:ListItem>
                                </asp:DropDownList>
&nbsp;<span style="font-family: Calibri; font-size: large"><strong>IN YEAR</strong></span>
                                <asp:DropDownList ID="DropDownList3" runat="server" AutoPostBack="True" 
                                    Height="25px" 
                                    style="font-weight: 700; font-family: Calibri; font-size: medium; color: #0000FF" 
                                    Width="60px">
                                    <asp:ListItem>2011</asp:ListItem>
                                    <asp:ListItem>2010</asp:ListItem>
                                    <asp:ListItem>2009</asp:ListItem>
                                </asp:DropDownList>
&nbsp;<span style="font-family: Calibri; font-size: large"><strong>IS</strong></span>
                                <asp:ListBox ID="ListBox10" runat="server" Height="26px" 
                                    DataSourceID="SqlDataSource9" DataTextField="Expr1" DataValueField="Expr1" 
                                    style="font-weight: 700; font-size: large; font-family: Calibri; text-transform: uppercase; color: #0000FF; border: thin #000000 dotted" 
                                    Width="70px"></asp:ListBox>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="7">
                                &nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="2">
                    <asp:SqlDataSource ID="SqlDataSource1" runat="server" 
                        ConnectionString="<%$ ConnectionStrings:cns1 %>" 
                        SelectCommand="SELECT [userName] FROM [user_Info]"></asp:SqlDataSource>
                            </td>
                            <td colspan="2">
                    <asp:SqlDataSource ID="SqlDataSource2" runat="server" 
                        ConnectionString="<%$ ConnectionStrings:cns1 %>" 
                        SelectCommand="SELECT [proID], [proName] FROM [product_Detail]">
                    </asp:SqlDataSource>
                            </td>
                            <td colspan="2">
                    <asp:SqlDataSource ID="SqlDataSource3" runat="server" 
                        ConnectionString="<%$ ConnectionStrings:cns1 %>" 
                        SelectCommand="SELECT SUM(proPrice) AS Expr1 FROM cart_Detail WHERE (userName = @userName)">
                        <SelectParameters>
                            <asp:ControlParameter ControlID="ListBox1" Name="userName" 
                                PropertyName="SelectedValue" />
                        </SelectParameters>
                    </asp:SqlDataSource>
                            </td>
                            <td>
                    <asp:SqlDataSource ID="SqlDataSource4" runat="server" 
                        ConnectionString="<%$ ConnectionStrings:cns1 %>" 
                        
                        SelectCommand="SELECT COUNT(proID) AS Expr1 FROM cart_Detail WHERE (proID = @proID)">
                        <SelectParameters>
                            <asp:ControlParameter ControlID="ListBox2" Name="proID" 
                                PropertyName="SelectedValue" />
                        </SelectParameters>
                    </asp:SqlDataSource>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                    <asp:SqlDataSource ID="SqlDataSource5" runat="server" 
                        ConnectionString="<%$ ConnectionStrings:cns1 %>" 
                        
                        SelectCommand="SELECT SUM(proPrice) AS Expr1 FROM cart_Detail WHERE (YEAR(buyDate) = @date)">
                        <SelectParameters>
                            <asp:ControlParameter ControlID="DropDownList1" Name="date" 
                                PropertyName="SelectedValue" />
                        </SelectParameters>
                    </asp:SqlDataSource>
                            </td>
                            <td colspan="2">
                    <asp:SqlDataSource ID="SqlDataSource6" runat="server" 
                        ConnectionString="<%$ ConnectionStrings:cns1 %>" 
                        SelectCommand="SELECT SUM(proPrice) AS Expr1 FROM cart_Detail">
                    </asp:SqlDataSource>
                            </td>
                            <td colspan="2">
                    <asp:SqlDataSource ID="SqlDataSource7" runat="server" 
                        ConnectionString="<%$ ConnectionStrings:cns1 %>" 
                        SelectCommand="SELECT SUM(proPrice) AS Expr1 FROM cart_Detail WHERE (DATEPART(d, buyDate) = DATEPART(d, { fn NOW() }))">
                    </asp:SqlDataSource>
                            </td>
                            <td>
                                <asp:SqlDataSource ID="SqlDataSource8" runat="server" 
                                    ConnectionString="<%$ ConnectionStrings:cns1 %>" 
                                    SelectCommand="SELECT userName, proName, proDetail, proPrice FROM cart_Detail WHERE (DATEPART(d, buyDate) = DATEPART(d, { fn NOW() }))">
                                </asp:SqlDataSource>
                            </td>
                        </tr>
                    </table>
                </div>
            </td>
        </tr>
    </table>
</asp:Content>

