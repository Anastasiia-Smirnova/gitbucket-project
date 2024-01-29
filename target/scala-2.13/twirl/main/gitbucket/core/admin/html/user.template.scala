
package gitbucket.core.admin.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object user extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Option[gitbucket.core.model.Account],List[String],Option[Any],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: Option[gitbucket.core.model.Account], extraMailAddresses: List[String], error: Option[Any] = None)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/gitbucket/*2.11*/.core.html.main(if(account.isEmpty) "New user" else "Update user")/*2.77*/{_display_(Seq[Any](format.raw/*2.78*/("""
  """),_display_(/*3.4*/gitbucket/*3.13*/.core.admin.html.menu("users")/*3.43*/{_display_(Seq[Any](format.raw/*3.44*/("""
    """),_display_(/*4.6*/gitbucket/*4.15*/.core.helper.html.error(error)),format.raw/*4.45*/("""
    """),format.raw/*5.5*/("""<form method="POST" validate="true" autocomplete="off">
      <div class="row">
        <div class="col-md-6">
          <fieldset class="form-group">
            <label for="userName" class="strong">Username:</label>
            <div>
              <span id="error-userName" class="error"></span>
            </div>
            <input type="text" name="userName" id="userName" class="form-control" value=""""),_display_(/*13.91*/account/*13.98*/.map(_.userName)),format.raw/*13.114*/("""""""),_display_(if(account.isDefined)/*13.137*/{_display_(Seq[Any](format.raw/*13.138*/(""" """),format.raw/*13.139*/("""readonly""")))} else {null} ),format.raw/*13.148*/("""/>
            """),_display_(if(account.isDefined)/*14.35*/{_display_(Seq[Any](format.raw/*14.36*/("""
              """),format.raw/*15.15*/("""<label for="removed">
                <input type="checkbox" name="removed" id="removed" value="true" """),_display_(if(account.get.isRemoved)/*16.107*/{_display_(Seq[Any](format.raw/*16.108*/("""checked""")))} else {null} ),format.raw/*16.116*/("""/>
                Disable
              </label>
              <div>
                <span id="error-removed" class="error"></span>
              </div>
            """)))} else {null} ),format.raw/*22.14*/("""
          """),format.raw/*23.11*/("""</fieldset>
          """),_display_(if(account.map(_.password.nonEmpty).getOrElse(true))/*24.64*/{_display_(Seq[Any](format.raw/*24.65*/("""
            """),format.raw/*25.13*/("""<fieldset class="form-group">
              <label for="password" class="strong">
                Password
                """),_display_(if(account.isDefined)/*28.39*/{_display_(Seq[Any](format.raw/*28.40*/("""
                  """),format.raw/*29.19*/("""(Input to change password)
                """)))} else {null} ),format.raw/*30.18*/("""
                """),format.raw/*31.17*/(""":
              </label>
              <div>
                <span id="error-password" class="error"></span>
              </div>
              <input type="password" name="password" id="password" class="form-control" value="" autocomplete="off"/>
            </fieldset>
          """)))} else {null} ),format.raw/*38.12*/("""
          """),format.raw/*39.11*/("""<fieldset class="form-group">
            <label for="fullName" class="strong">Full Name:</label>
            <div>
              <span id="error-fullName" class="error"></span>
            </div>
            <input type="text" name="fullName" id="fullName" class="form-control" value=""""),_display_(/*44.91*/account/*44.98*/.map(_.fullName)),format.raw/*44.114*/(""""/>
          </fieldset>
          <fieldset class="form-group">
            <label for="mailAddress" class="strong">Mail Address:</label>
            <div>
              <span id="error-mailAddress" class="error"></span>
            </div>
            <input type="text" name="mailAddress" id="mailAddress" class="form-control" value=""""),_display_(/*51.97*/account/*51.104*/.map(_.mailAddress)),format.raw/*51.123*/(""""/>
          </fieldset>
          <fieldset class="form-group" id="extraMailAddresses">
            <span class="strong">Additional Mail Address:</span>
            """),_display_(/*55.14*/extraMailAddresses/*55.32*/.zipWithIndex.map/*55.49*/ { case (mail, idx) =>_display_(Seq[Any](format.raw/*55.71*/("""
            """),format.raw/*56.13*/("""<input type="text" name="extraMailAddresses["""),_display_(/*56.58*/idx),format.raw/*56.61*/("""]" id="extraMailAddresses["""),_display_(/*56.88*/idx),format.raw/*56.91*/("""]" class="form-control extraMailAddress" value=""""),_display_(/*56.140*/mail),format.raw/*56.144*/("""" aria-label="Additional mail address"/>
            <span id="error-extraMailAddresses_"""),_display_(/*57.49*/idx),format.raw/*57.52*/("""" class="error"></span>
            """)))}),format.raw/*58.14*/("""
          """),format.raw/*59.11*/("""</fieldset>
          <fieldset class="form-group">
            <label class="strong">User Type:</label>
            <label class="radio" for="userType_Normal">
              <input type="radio" name="isAdmin" id="userType_Normal" value="false""""),_display_(if(account.isEmpty || !account.get.isAdmin)/*63.128*/{_display_(Seq[Any](format.raw/*63.129*/(""" """),format.raw/*63.130*/("""checked""")))} else {null} ),format.raw/*63.138*/("""/> Normal
            </label>
            <label class="radio" for="userType_Admin">
              <input type="radio" name="isAdmin" id="userType_Admin" value="true""""),_display_(if(account.isDefined && account.get.isAdmin)/*66.127*/{_display_(Seq[Any](format.raw/*66.128*/(""" """),format.raw/*66.129*/("""checked""")))} else {null} ),format.raw/*66.137*/("""/> Administrator
            </label>
          </fieldset>
          <fieldset class="form-group">
            <label class="strong" for="url">URL (Optional):</label>
            <div>
              <span id="error-url" class="error"></span>
            </div>
            <input type="text" name="url" id="url" class="form-control" value=""""),_display_(/*74.81*/account/*74.88*/.map(_.url)),format.raw/*74.99*/(""""/>
          </fieldset>
          <fieldset class="form-group">
            <label class="strong" for="description">Bio (Optional):</label>
            <div>
              <span id="error-description" class="error"></span>
            </div>
            <textarea name="description" id="description" class="form-control">"""),_display_(/*81.81*/account/*81.88*/.map(_.description)),format.raw/*81.107*/("""</textarea>
          </fieldset>
        </div>
        <div class="col-md-6">
          <fieldset class="form-group">
            <label for="avatar" class="strong">Image (Optional)</label>
            """),_display_(/*87.14*/gitbucket/*87.23*/.core.helper.html.uploadavatar(account)),format.raw/*87.62*/("""
          """),format.raw/*88.11*/("""</fieldset>
        </div>
      </div>
      <fieldset class="border-top">
        """),_display_(if(account.isEmpty)/*92.29*/{_display_(Seq[Any](format.raw/*92.30*/("""
          """),format.raw/*93.11*/("""<input type="submit" class="btn btn-success" value="Create user" formaction=""""),_display_(/*93.89*/context/*93.96*/.path),format.raw/*93.101*/("""/admin/users/_newuser"/>
        """)))}else/*94.16*/{_display_(Seq[Any](format.raw/*94.17*/("""
          """),format.raw/*95.11*/("""<input type="submit" class="btn btn-success" value="Update user" formaction=""""),_display_(/*95.89*/context/*95.96*/.path),format.raw/*95.101*/("""/admin/users/"""),_display_(/*95.115*/account/*95.122*/.get.userName),format.raw/*95.135*/("""/_edituser" id="update"/>
        """)))}),format.raw/*96.10*/("""
        """),format.raw/*97.9*/("""<a href=""""),_display_(/*97.19*/context/*97.26*/.path),format.raw/*97.31*/("""/admin/users" class="btn btn-default">Cancel</a>
      </fieldset>
    </form>
  """)))}),format.raw/*100.4*/("""
""")))}),format.raw/*101.2*/("""
"""),format.raw/*102.1*/("""<script>
$(function()"""),format.raw/*103.13*/("""{"""),format.raw/*103.14*/("""
  """),format.raw/*104.3*/("""addExtraMailAddress();
  $('#extraMailAddresses').on('change', '.extraMailAddress', checkExtraMailAddress);
  $('#update').click(function()"""),format.raw/*106.32*/("""{"""),format.raw/*106.33*/("""
    """),format.raw/*107.5*/("""if($('#password').val() != '')"""),format.raw/*107.35*/("""{"""),format.raw/*107.36*/("""
      """),format.raw/*108.7*/("""return confirm('Are you sure you want to change password of this user?');
    """),format.raw/*109.5*/("""}"""),format.raw/*109.6*/(""" """),format.raw/*109.7*/("""else """),format.raw/*109.12*/("""{"""),format.raw/*109.13*/("""
      """),format.raw/*110.7*/("""return true;
    """),format.raw/*111.5*/("""}"""),format.raw/*111.6*/("""
  """),format.raw/*112.3*/("""}"""),format.raw/*112.4*/(""");
"""),format.raw/*113.1*/("""}"""),format.raw/*113.2*/(""");
</script>
"""))
      }
    }
  }

  def render(account:Option[gitbucket.core.model.Account],extraMailAddresses:List[String],error:Option[Any],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,extraMailAddresses,error)(context)

  def f:((Option[gitbucket.core.model.Account],List[String],Option[Any]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,extraMailAddresses,error) => (context) => apply(account,extraMailAddresses,error)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/admin/user.scala.html
                  HASH: 03bc185ac09f18e6240279c581c74cd4574c22d4
                  MATRIX: 669->1|924->164|941->173|1015->239|1053->240|1082->244|1099->253|1137->283|1175->284|1206->290|1223->299|1273->329|1304->334|1738->741|1754->748|1792->764|1843->787|1883->788|1913->789|1967->798|2031->835|2070->836|2113->851|2269->979|2309->980|2362->988|2573->1155|2612->1166|2714->1241|2753->1242|2794->1255|2966->1400|3005->1401|3052->1420|3140->1464|3185->1481|3512->1764|3551->1775|3865->2062|3881->2069|3919->2085|4284->2423|4301->2430|4342->2449|4537->2617|4564->2635|4590->2652|4650->2674|4691->2687|4763->2732|4787->2735|4841->2762|4865->2765|4942->2814|4968->2818|5084->2907|5108->2910|5176->2947|5215->2958|5531->3246|5571->3247|5601->3248|5654->3256|5894->3468|5934->3469|5964->3470|6017->3478|6386->3820|6402->3827|6434->3838|6785->4162|6801->4169|6842->4188|7074->4393|7092->4402|7152->4441|7191->4452|7322->4556|7361->4557|7400->4568|7505->4646|7521->4653|7548->4658|7605->4698|7644->4699|7683->4710|7788->4788|7804->4795|7831->4800|7873->4814|7890->4821|7925->4834|7991->4869|8027->4878|8064->4888|8080->4895|8106->4900|8219->4982|8252->4984|8281->4985|8331->5006|8361->5007|8392->5010|8560->5149|8590->5150|8623->5155|8682->5185|8712->5186|8747->5193|8853->5271|8882->5272|8911->5273|8945->5278|8975->5279|9010->5286|9055->5303|9084->5304|9115->5307|9144->5308|9175->5311|9204->5312
                  LINES: 14->1|19->2|19->2|19->2|19->2|20->3|20->3|20->3|20->3|21->4|21->4|21->4|22->5|30->13|30->13|30->13|30->13|30->13|30->13|30->13|31->14|31->14|32->15|33->16|33->16|33->16|39->22|40->23|41->24|41->24|42->25|45->28|45->28|46->29|47->30|48->31|55->38|56->39|61->44|61->44|61->44|68->51|68->51|68->51|72->55|72->55|72->55|72->55|73->56|73->56|73->56|73->56|73->56|73->56|73->56|74->57|74->57|75->58|76->59|80->63|80->63|80->63|80->63|83->66|83->66|83->66|83->66|91->74|91->74|91->74|98->81|98->81|98->81|104->87|104->87|104->87|105->88|109->92|109->92|110->93|110->93|110->93|110->93|111->94|111->94|112->95|112->95|112->95|112->95|112->95|112->95|112->95|113->96|114->97|114->97|114->97|114->97|117->100|118->101|119->102|120->103|120->103|121->104|123->106|123->106|124->107|124->107|124->107|125->108|126->109|126->109|126->109|126->109|126->109|127->110|128->111|128->111|129->112|129->112|130->113|130->113
                  -- GENERATED --
              */
          