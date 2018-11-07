<%@ Page Title="" Language="C#" MasterPageFile="~/musicvalley.master" AutoEventWireup="true" CodeFile="userinfo.aspx.cs" Inherits="Default2" %>

<asp:Content ID="Content1" runat="server" contentplaceholderid="ContentPlaceHolder1">
    <table style="width: 100%; height: 678px;">
            <tr>
                <td style="border: thin #000000 dotted; height: 49px; text-align: center; text-transform: uppercase;">
                    <div>
                        <span style="color: #0000FF"><strong>&nbsp;</strong></span><span 
                            style="color: #FF0000">&nbsp;</span><strong><span 
                            style="font-family: Calibri; font-size: large"><span style="color: #FF0000">&lt;&lt;</span>
                        </span>
                        <asp:Label ID="Label3" runat="server" Text="Label" 
                            style="font-family: Calibri; font-size: large; color: #00CCFF"></asp:Label>
                        <span style="font-family: Calibri; font-size: large">&nbsp;<span 
                            style="color: #0000FF">EDIT UR DETAILS</span> <span style="color: #FF0000">
                        &gt;&gt;</span></span></strong></div>
                </td>
            </tr>
            <tr> 
                <td>
                    <div style="height: 633px">
                        <table style="width: 100%; height: 624px;">
                            <tr>
                                <td style="height: 66px">
                                    <div style="height: 60px">
                                        <table style="border: thin #000000 dotted; width:100%;">
                                            <tr>
                                                <td>
                                    <span style="color: #0000FF; font-family: Calibri; font-size: large;"><strong> PROFILE IMAGE</strong></span></td>
                                            </tr>
                                            <tr>
                                                <td>
                                    <asp:FileUpload ID="FileUpload1" runat="server" Width="220px" 
                            style="margin-left: 0px" BorderStyle="Ridge" Font-Bold="True" Font-Names="Calibri" 
                                        Font-Size="Small" />
&nbsp;&nbsp;&nbsp;<asp:ImageButton ID="ImageButton1" runat="server" Height="29px" 
                            ImageUrl="~/WebImages/upload 22.jpg" Width="32px" onclick="ImageButton1_Click" 
                                        EnableTheming="True" ValidationGroup="a" />
                                    &nbsp;<asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" 
                                        ControlToValidate="FileUpload1" ErrorMessage="* U HAVE TO BROWSE FIRST..." 
                                            style="color: #6600FF; font-family: Calibri; font-size: small" ForeColor="#FF5050" 
                                                        ValidationGroup="a"></asp:RequiredFieldValidator>
                                                &nbsp;</td>
                                            </tr>
                                        </table>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div style="border: thin #000000 dotted; height: 556px; font-family: Calibri; font-size: large; text-transform: uppercase; ">
                                        <asp:ScriptManager ID="ScriptManager1" runat="server">
                                        </asp:ScriptManager>
    
                                        <br />
                                        <span style="color: #0000FF"><strong> CONTACT &amp; SHOPPING DETAILS<br />
                                        </strong></span>
                                        <br />
    
        <asp:FormView ID="FormView1" runat="server" 
            onpageindexchanging="FormView1_PageIndexChanging" 
            oniteminserting="FormView1_ItemInserting" 
            onitemupdating="FormView1_ItemUpdating" 
            onmodechanging="FormView1_ModeChanging" DataKeyNames="userName" Width="373px">
            <EditItemTemplate>
                <table style="width:100%;">
                    <tr>
                        <td class="style32">
                            <strong>&nbsp;CONTACT INFO</strong></td>
                        <td>
                            <asp:LinkButton ID="LinkButton2" runat="server" CommandName="update">UPDATE</asp:LinkButton>
                            &nbsp;
                            <asp:LinkButton ID="LinkButton3" runat="server" CommandName="cancel">CANCEL</asp:LinkButton>
                        </td>
                    </tr>
                    <tr>
                        <td class="style32">
                            &nbsp;</td>
                        <td>
                            &nbsp;</td>
                    </tr>
                    <tr>
                        <td class="style32">
                            FIRST NAME</td>
                        <td>
                            <asp:TextBox ID="TextBox1" runat="server" Text='<%#Eval("firstName")%>'></asp:TextBox>
                            <asp:RequiredFieldValidator ID="RequiredFieldValidator11" runat="server" 
                                ControlToValidate="TextBox1" ErrorMessage="*" style="font-size: small" 
                                ValidationGroup="edit"></asp:RequiredFieldValidator>
                        </td>
                    </tr>
                    <tr>
                        <td class="style32">
                            LAST NAME</td>
                        <td>
                            <asp:TextBox ID="TextBox2" runat="server" Text='<%#Eval("lastName")%>'></asp:TextBox>
                            <asp:RequiredFieldValidator ID="RequiredFieldValidator12" runat="server" 
                                ControlToValidate="TextBox2" ErrorMessage="*" style="font-size: small" 
                                ValidationGroup="edit"></asp:RequiredFieldValidator>
                        </td>
                    </tr>
                    <tr>
                        <td class="style32">
                            GENDER</td>
                        <td>
                            <asp:DropDownList ID="DropDownList1" runat="server">
                                <asp:ListItem>Male</asp:ListItem>
                                <asp:ListItem>Female</asp:ListItem>
                            </asp:DropDownList>
                        </td>
                    </tr>
                    <tr>
                        <td class="style32">
                            CONTACT NO</td>
                        <td>
                            <asp:TextBox ID="TextBox3" runat="server" Text='<%#Eval("contactNumber")%>'></asp:TextBox>
                            <asp:RequiredFieldValidator ID="RequiredFieldValidator13" runat="server" 
                                ControlToValidate="TextBox3" ErrorMessage="*" style="font-size: small" 
                                ValidationGroup="edit"></asp:RequiredFieldValidator>
                            <asp:RegularExpressionValidator ID="RegularExpressionValidator3" runat="server" 
                                ControlToValidate="TextBox3" ErrorMessage="10 digit only" 
                                style="font-size: small" ValidationExpression="\d{10}" ValidationGroup="edit"></asp:RegularExpressionValidator>
                            <asp:CompareValidator ID="CompareValidator4" runat="server" 
                                ControlToValidate="TextBox3" ErrorMessage="numeric only" 
                                Operator="DataTypeCheck" style="font-size: small" Type="Double" 
                                ValidationGroup="edit"></asp:CompareValidator>
                        </td>
                    </tr>
                    <tr>
                        <td class="style32">
                            </td>
                        <td class="style3">
                            </td>
                    </tr>
                    <tr>
                        <td class="style32">
                            <strong>SHIPPING ADDRESS</strong></td>
                        <td rowspan="2">
                            &nbsp;</td>
                    </tr>
                    <tr>
                        <td class="style32">
                            &nbsp;</td>
                    </tr>
                    <tr>
                        <td class="style32">
                            ADDRESS
                        </td>
                        <td>
                            <asp:TextBox ID="TextBox4" runat="server" Text='<%#Eval("userAddress")%>'></asp:TextBox>
                            <asp:RequiredFieldValidator ID="RequiredFieldValidator14" runat="server" 
                                ControlToValidate="TextBox4" ErrorMessage="*" style="font-size: small" 
                                ValidationGroup="edit"></asp:RequiredFieldValidator>
                        </td>
                    </tr>
                    <tr>
                        <td class="style32">
                            COUNTRY
                        </td>
                        <td rowspan="3">
                            <asp:UpdatePanel ID="UpdatePanel7" runat="server">
                                <ContentTemplate>
                                    <asp:DropDownList ID="DropDownList9" runat="server" 
                                        DataSourceID="SqlDataSource11" DataTextField="country" DataValueField="country" 
                                        onselectedindexchanged="DropDownList9_SelectedIndexChanged" 
                                        AutoPostBack="True">
                                    </asp:DropDownList>
                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator15" runat="server" 
                                        ControlToValidate="DropDownList9" ErrorMessage="*" style="font-size: small" 
                                        ValidationGroup="edit"></asp:RequiredFieldValidator>
                                    <asp:SqlDataSource ID="SqlDataSource11" runat="server" 
                                        ConnectionString="<%$ ConnectionStrings:cns1 %>" 
                                        SelectCommand="SELECT DISTINCT country FROM user_Location">
                                    </asp:SqlDataSource>
                                    <asp:UpdatePanel ID="UpdatePanel8" runat="server">
                                        <ContentTemplate>
                                            <asp:DropDownList ID="DropDownList10" runat="server" 
                                                DataSourceID="SqlDataSource12" DataTextField="state" DataValueField="state" 
                                                onselectedindexchanged="DropDownList10_SelectedIndexChanged" 
                                                AutoPostBack="True">
                                            </asp:DropDownList>
                                            <asp:RequiredFieldValidator ID="RequiredFieldValidator16" runat="server" 
                                                ControlToValidate="DropDownList10" ErrorMessage="*" style="font-size: small" 
                                                ValidationGroup="edit"></asp:RequiredFieldValidator>
                                            <asp:SqlDataSource ID="SqlDataSource12" runat="server" 
                                                ConnectionString="<%$ ConnectionStrings:cns1 %>" 
                                                SelectCommand="SELECT DISTINCT state FROM user_Location WHERE (country = @country)">
                                                <SelectParameters>
                                                <asp:Parameter Name="country" Type="string" />
                                                   <%-- <asp:ControlParameter ControlID="DropDownList9" Name="country" 
                                                        PropertyName="SelectedValue" />--%>
                                                </SelectParameters>
                                            </asp:SqlDataSource>
                                            <asp:UpdatePanel ID="UpdatePanel9" runat="server">
                                                <ContentTemplate>
                                                    <asp:DropDownList ID="DropDownList11" runat="server" 
                                                        DataSourceID="SqlDataSource13" DataTextField="city" DataValueField="city" 
                                                        onselectedindexchanged="DropDownList11_SelectedIndexChanged" 
                                                        AutoPostBack="True">
                                                    </asp:DropDownList>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator17" runat="server" 
                                                        ControlToValidate="DropDownList11" ErrorMessage="*" style="font-size: small" 
                                                        ValidationGroup="edit"></asp:RequiredFieldValidator>
                                                    <asp:SqlDataSource ID="SqlDataSource13" runat="server" 
                                                        ConnectionString="<%$ ConnectionStrings:cns1 %>" SelectCommand="
SELECT DISTINCT city FROM user_Location WHERE (state = @state)">
                                                        <SelectParameters>
                                                        <asp:Parameter Name="state" Type="string" />
                                                            <%--<asp:ControlParameter ControlID="DropDownList10" Name="state" 
                                                                PropertyName="SelectedValue" />--%>
                                                        </SelectParameters>
                                                    </asp:SqlDataSource>
                                                </ContentTemplate>
                                            </asp:UpdatePanel>
                                        </ContentTemplate>
                                    </asp:UpdatePanel>
                                </ContentTemplate>
                            </asp:UpdatePanel>
                        </td>
                    </tr>
                    <tr>
                        <td class="style32">
                            STATE</td>
                    </tr>
                    <tr>
                        <td class="style32">
                            CITY</td>
                    </tr>
                    <tr>
                        <td class="style32">
                            PIN CODE</td>
                        <td>
                            <asp:TextBox ID="TextBox5" runat="server" Text='<%#Eval("postalCode")%>'></asp:TextBox>
                            <asp:RequiredFieldValidator ID="RequiredFieldValidator18" runat="server" 
                                ControlToValidate="TextBox5" ErrorMessage="*" style="font-size: small" 
                                ValidationGroup="edit"></asp:RequiredFieldValidator>
                            <asp:RegularExpressionValidator ID="RegularExpressionValidator4" runat="server" 
                                ControlToValidate="TextBox5" ErrorMessage="6 digit only" 
                                style="font-size: small" ValidationExpression="\d{6}" ValidationGroup="edit"></asp:RegularExpressionValidator>
                            <asp:CompareValidator ID="CompareValidator5" runat="server" 
                                ControlToValidate="TextBox5" ErrorMessage="numeric only" 
                                Operator="DataTypeCheck" style="font-size: small" Type="Integer" 
                                ValidationGroup="edit"></asp:CompareValidator>
                        </td>
                    </tr>
                    <tr>
                        <td class="style32">
                            &nbsp;</td>
                        <td>
                            &nbsp;</td>
                    </tr>
                    <tr>
                        <td class="style32">
                            <asp:Label ID="Label1" runat="server"  Text='<%#Eval("userName")%>'></asp:Label>
                        </td>
                        <td>
                            &nbsp;</td>
                    </tr>
                </table>
            </EditItemTemplate>
            <EmptyDataTemplate>
                <asp:LinkButton ID="LinkButton4" runat="server" CommandName="new">FILL DETAILS</asp:LinkButton>
            </EmptyDataTemplate>
            <InsertItemTemplate>
                <table style="width:100%;">
                    <tr>
                        <td class="style32" style="width: 187px">
                            <strong>&nbsp;CONTACT INFO</strong></td>
                        <td>
                            <asp:LinkButton ID="LinkButton5" runat="server" CommandName="insert" >SAVE</asp:LinkButton>
                            &nbsp;
                            <asp:LinkButton ID="LinkButton6" runat="server" CommandName="cancel">CANCEL</asp:LinkButton>
                        </td>
                    </tr>
                    <tr>
                        <td class="style32" style="width: 187px">
                            &nbsp;</td>
                        <td>
                            &nbsp;</td>
                    </tr>
                    <tr>
                        <td class="style32" style="width: 187px">
                            FIRST NAME</td>
                        <td>
                            <asp:TextBox ID="TextBox6" runat="server"></asp:TextBox>
                            <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" 
                                ControlToValidate="TextBox6" ErrorMessage="*" style="font-size: small" 
                                ValidationGroup="ins"></asp:RequiredFieldValidator>
                        </td>
                    </tr>
                    <tr>
                        <td class="style32" style="width: 187px">
                            LAST NAME</td>
                        <td>
                            <asp:TextBox ID="TextBox7" runat="server"></asp:TextBox>
                            <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" 
                                ControlToValidate="TextBox7" ErrorMessage="* " style="font-size: small" 
                                ValidationGroup="ins"></asp:RequiredFieldValidator>
                        </td>
                    </tr>
                    <tr>
                        <td class="style32" style="width: 187px">
                            GENDER</td>
                        <td>
                            <asp:DropDownList ID="DropDownList5" runat="server">
                                <asp:ListItem>Male</asp:ListItem>
                                <asp:ListItem>Female</asp:ListItem>
                            </asp:DropDownList>
                        </td>
                    </tr>
                    <tr>
                        <td class="style32" style="width: 187px">
                            CONTACT NO</td>
                        <td>
                            <asp:TextBox ID="TextBox8" runat="server"></asp:TextBox>
                            <asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" 
                                ControlToValidate="TextBox8" ErrorMessage="*" style="font-size: small" 
                                ValidationGroup="ins"></asp:RequiredFieldValidator>
                            <asp:RegularExpressionValidator ID="RegularExpressionValidator1" runat="server" 
                                ControlToValidate="TextBox8" ErrorMessage="10 digit only" 
                                style="font-size: small" ValidationExpression="\d{10}" ValidationGroup="ins"></asp:RegularExpressionValidator>
                            <asp:CompareValidator ID="CompareValidator2" runat="server" 
                                ControlToValidate="TextBox8" ErrorMessage="numeric only" 
                                Operator="DataTypeCheck" style="font-size: small" Type="Double" 
                                ValidationGroup="ins"></asp:CompareValidator>
                        </td>
                    </tr>
                    <tr>
                        <td style="height: 26px; width: 187px;">
                            </td>
                        <td style="height: 26px">
                            </td>
                    </tr>
                    <tr>
                        <td class="style32" style="width: 187px">
                            <strong>SHIPPING ADDRESS</strong></td>
                        <td rowspan="2">
                            &nbsp;</td>
                    </tr>
                    <tr>
                        <td class="style32" style="width: 187px">
                            &nbsp;</td>
                    </tr>
                    <tr>
                        <td class="style32" style="width: 187px">
                            ADDRESS
                        </td>
                        <td>
                            <asp:TextBox ID="TextBox9" runat="server"></asp:TextBox>
                            <asp:RequiredFieldValidator ID="RequiredFieldValidator5" runat="server" 
                                ControlToValidate="TextBox9" ErrorMessage="*" style="font-size: small" 
                                ValidationGroup="ins"></asp:RequiredFieldValidator>
                        </td>
                    </tr>
                    <tr>
                        <td class="style32" style="width: 187px">
                            COUNTRY
                        </td>
                        <td rowspan="3">
                            <asp:UpdatePanel ID="UpdatePanel4" runat="server">
                                <ContentTemplate>
                                    <asp:DropDownList ID="DropDownList6" runat="server" 
                                        DataSourceID="SqlDataSource4" DataTextField="country" DataValueField="country" 
                                        onselectedindexchanged="DropDownList6_SelectedIndexChanged" 
                                        AutoPostBack="True">
                                    </asp:DropDownList>
                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator7" runat="server" 
                                        ControlToValidate="DropDownList6" ErrorMessage="*" 
                                        style="font-size: small" ValidationGroup="ins"></asp:RequiredFieldValidator>
                                    <asp:SqlDataSource ID="SqlDataSource4" runat="server" 
                                        ConnectionString="<%$ ConnectionStrings:cns1 %>" 
                                        SelectCommand="SELECT DISTINCT country FROM user_Location">
                                    </asp:SqlDataSource>
                                    <asp:UpdatePanel ID="UpdatePanel5" runat="server">
                                        <ContentTemplate>
                                            <asp:DropDownList ID="DropDownList7" runat="server" 
                                                DataSourceID="SqlDataSource5" DataTextField="state" DataValueField="state" 
                                                onselectedindexchanged="DropDownList7_SelectedIndexChanged" 
                                                AutoPostBack="True">
                                            </asp:DropDownList>
                                            <asp:RequiredFieldValidator ID="RequiredFieldValidator8" runat="server" 
                                                ControlToValidate="DropDownList7" ErrorMessage="*" 
                                                style="font-size: small" ValidationGroup="ins"></asp:RequiredFieldValidator>
                                            <asp:SqlDataSource ID="SqlDataSource5" runat="server" 
                                                ConnectionString="<%$ ConnectionStrings:cns1 %>" 
                                                SelectCommand="SELECT DISTINCT state FROM user_Location WHERE (country = @country)">
                                                <SelectParameters>
                                                 <asp:Parameter Name="country" Type="string" />
                                                    <%--<asp:ControlParameter ControlID="DropDownList6" Name="country" 
                                                        PropertyName="SelectedValue" />--%>
                                                </SelectParameters>
                                            </asp:SqlDataSource>
                                            <asp:UpdatePanel ID="UpdatePanel6" runat="server">
                                                <ContentTemplate>
                                                    <asp:DropDownList ID="DropDownList8" runat="server" 
                                                        DataSourceID="SqlDataSource6" DataTextField="city" DataValueField="city" 
                                                        onselectedindexchanged="DropDownList8_SelectedIndexChanged" 
                                                        AutoPostBack="True">
                                                    </asp:DropDownList>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator9" runat="server" 
                                                        ControlToValidate="DropDownList8" ErrorMessage="*" 
                                                        style="font-size: small" ValidationGroup="ins"></asp:RequiredFieldValidator>
                                                    <asp:SqlDataSource ID="SqlDataSource6" runat="server" 
                                                        ConnectionString="<%$ ConnectionStrings:cns1 %>" 
                                                        SelectCommand="SELECT DISTINCT city FROM user_Location WHERE (state = @state)">
                                                        <SelectParameters>
                                                         <asp:Parameter Name="state" Type="string" />
                                                            <%--<asp:ControlParameter ControlID="DropDownList7" Name="state" 
                                                                PropertyName="SelectedValue" />--%>
                                                        </SelectParameters>
                                                    </asp:SqlDataSource>
                                                </ContentTemplate>
                                            </asp:UpdatePanel>
                                        </ContentTemplate>
                                    </asp:UpdatePanel>
                                </ContentTemplate>
                            </asp:UpdatePanel>
                        </td>
                    </tr>
                    <tr>
                        <td class="style32" style="width: 187px">
                            STATE</td>
                    </tr>
                    <tr>
                        <td class="style32" style="width: 187px">
                            CITY</td>
                    </tr>
                    <tr>
                        <td class="style32" style="width: 187px">
                            PIN CODE</td>
                        <td>
                            <asp:TextBox ID="TextBox10" runat="server"></asp:TextBox>
                            <asp:RequiredFieldValidator ID="RequiredFieldValidator10" runat="server" 
                                ControlToValidate="TextBox10" ErrorMessage="*" style="font-size: small" 
                                ValidationGroup="ins"></asp:RequiredFieldValidator>
                            <asp:RegularExpressionValidator ID="RegularExpressionValidator2" runat="server" 
                                ControlToValidate="TextBox10" ErrorMessage="6 digit only" 
                                style="font-size: small" ValidationExpression="\d{6}" ValidationGroup="ins"></asp:RegularExpressionValidator>
                            <asp:CompareValidator ID="CompareValidator3" runat="server" 
                                ControlToValidate="TextBox10" ErrorMessage="numeric only" 
                                Operator="DataTypeCheck" style="font-size: small" Type="Integer" 
                                ValidationGroup="ins"></asp:CompareValidator>
                        </td>
                    </tr>
                    <tr>
                        <td class="style32" style="width: 187px">
                            &nbsp;</td>
                        <td>
                            &nbsp;</td>
                    </tr>
                    <tr>
                        <td class="style32" style="width: 187px">
                            &nbsp;</td>
                        <td>
                            &nbsp;</td>
                    </tr>
                </table>
            </InsertItemTemplate>
            <ItemTemplate>
                <table style="width:100%;">
                    <tr>
                        <td class="style2">
                            &nbsp;<strong>CONTACT INFO</strong></td>
                        <td>
                            <asp:LinkButton ID="LinkButton1" runat="server" CommandName="edit">CHANGE</asp:LinkButton>
                            &nbsp;<%--<%#Eval("userName")%></td>--%></tr>
                    <tr>
                        <td class="style2">
                            &nbsp;</td>
                        <td>
                            &nbsp;</td>
                    </tr>
                    <tr>
                        <td class="style2">
                            FIRST NAME</td>
                        <td>
                            &nbsp;<%#Eval("firstName")%></td>
                    </tr>
                    <tr>
                        <td class="style2">
                            LAST NAME</td>
                        <td>
                            &nbsp;<%#Eval("lastName")%></td>
                    </tr>
                    <tr>
                        <td class="style2">
                            GENDER</td>
                        <td>
                            &nbsp;<%#Eval("userGender")%></td>
                    </tr>
                    <tr>
                        <td class="style2">
                            CONTACT NO</td>
                        <td>
                            &nbsp;<%#Eval("contactNumber")%></td>
                    </tr>
                    <tr>
                        <td class="style2">
                            &nbsp;</td>
                        <td>
                            &nbsp;</td>
                    </tr>
                    <tr>
                        <td class="style2">
                            <strong>SHIPPING ADDRESS</strong></td>
                        <td>
                            <asp:LinkButton ID="LinkButton7" runat="server" CommandName="edit">CHANGE</asp:LinkButton>
                        </td>
                    </tr>
                    <tr>
                        <td class="style2">
                            &nbsp;</td>
                        <td>
                            &nbsp;</td>
                    </tr>
                    <tr>
                        <td class="style2">
                            ADDRESS
                        </td>
                        <td>
                            &nbsp;<%#Eval("userAddress")%></td>
                    </tr>
                    <tr>
                        <td class="style2">
                            COUNTRY
                        </td>
                        <td>
                            &nbsp;<%#Eval("userCountry")%></td>
                    </tr>
                    <tr>
                        <td class="style2">
                            STATE</td>
                        <td>
                            &nbsp;<%#Eval("userState")%></td>
                    </tr>
                    <tr>
                        <td class="style2">
                            CITY</td>
                        <td>
                            &nbsp;<%#Eval("userCity")%></td>
                    </tr>
                    <tr>
                        <td class="style2">
                            PIN CODE</td>
                        <td>
                            &nbsp;<%#Eval("postalCode")%></td>
                    </tr>
                    <tr>
                        <td class="style2">
                            &nbsp;</td>
                        <td>
                            &nbsp;</td>
                    </tr>
                    <tr>
                        <td class="style2">
                            &nbsp;</td>
                        <td>
                            &nbsp;</td>
                    </tr>
                </table>
            </ItemTemplate>
        </asp:FormView>
    
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


