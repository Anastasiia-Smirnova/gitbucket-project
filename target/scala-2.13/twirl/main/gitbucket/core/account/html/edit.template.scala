
package gitbucket.core.account.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[gitbucket.core.model.Account,List[String],Option[Any],Option[Any],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: gitbucket.core.model.Account, extraMailAddresses: List[String], info: Option[Any], error: Option[Any])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import gitbucket.core.util.LDAPUtil
/*3.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*4.2*/gitbucket/*4.11*/.core.html.main("Edit your profile")/*4.47*/{_display_(Seq[Any](format.raw/*4.48*/("""
  """),_display_(/*5.4*/gitbucket/*5.13*/.core.account.html.menu("profile", context.loginAccount.get.userName, false)/*5.89*/{_display_(Seq[Any](format.raw/*5.90*/("""
    """),_display_(/*6.6*/gitbucket/*6.15*/.core.helper.html.information(info)),format.raw/*6.50*/("""
    """),_display_(/*7.6*/gitbucket/*7.15*/.core.helper.html.error(error)),format.raw/*7.45*/("""
    """),_display_(if(LDAPUtil.isDummyMailAddress(account))/*8.46*/{_display_(Seq[Any](format.raw/*8.47*/("""<div class="alert alert-danger">Please register your mail address.</div>""")))} else {null} ),format.raw/*8.120*/("""
    """),format.raw/*9.5*/("""<form action=""""),_display_(/*9.20*/helpers/*9.27*/.url(account.userName)),format.raw/*9.49*/("""/_edit" method="POST" validate="true" autocomplete="off">
      <div class="panel panel-default">
        <div class="panel-heading strong">Profile</div>
        <div class="panel-body">
          <div class="row">
            <div class="col-md-6">
              """),_display_(if(account.password.nonEmpty)/*15.45*/{_display_(Seq[Any](format.raw/*15.46*/("""
                """),format.raw/*16.17*/("""<fieldset class="form-group">
                  <label for="password" class="strong">
                    Password (input to change password):
                  </label>
                  <input type="password" name="password" id="password" class="form-control" value="" autocomplete="off"/>
                  <span id="error-password" class="error"></span>
                </fieldset>
              """)))} else {null} ),format.raw/*23.16*/("""
              """),format.raw/*24.15*/("""<fieldset class="form-group">
                <label for="fullName" class="strong">Full Name:</label>
                <input type="text" name="fullName" id="fullName" class="form-control" value=""""),_display_(/*26.95*/account/*26.102*/.fullName),format.raw/*26.111*/(""""/>
                <span id="error-fullName" class="error"></span>
              </fieldset>
              <fieldset class="form-group">
                <label for="mailAddress" class="strong">Mail Address:</label>
                <input type="text" name="mailAddress" id="mailAddress" class="form-control" value=""""),_display_(if(!LDAPUtil.isDummyMailAddress(account))/*31.142*/{_display_(_display_(/*31.144*/account/*31.151*/.mailAddress))} else {null} ),format.raw/*31.164*/(""""/>
                <span id="error-mailAddress" class="error"></span>
              </fieldset>
              <fieldset class="form-group" id="extraMailAddresses">
                <span class="strong">Additional Mail Address:</span>
                """),_display_(/*36.18*/extraMailAddresses/*36.36*/.zipWithIndex.map/*36.53*/ { case (mail, idx) =>_display_(Seq[Any](format.raw/*36.75*/("""
                  """),format.raw/*37.19*/("""<input type="text" name="extraMailAddresses["""),_display_(/*37.64*/idx),format.raw/*37.67*/("""]" id="extraMailAddresses["""),_display_(/*37.94*/idx),format.raw/*37.97*/("""]" class="form-control extraMailAddress" value=""""),_display_(/*37.146*/mail),format.raw/*37.150*/("""" aria-label="Additional mail address"/>
                  <span id="error-extraMailAddresses_"""),_display_(/*38.55*/idx),format.raw/*38.58*/("""" class="error"></span>
                """)))}),format.raw/*39.18*/("""
              """),format.raw/*40.15*/("""</fieldset>
              <fieldset class="form-group">
                <label for="url" class="strong">URL (optional):</label>
                <input type="text" name="url" id="url" class="form-control" value=""""),_display_(/*43.85*/account/*43.92*/.url),format.raw/*43.96*/(""""/>
                <span id="error-url" class="error"></span>
              </fieldset>
              <fieldset class="form-group">
                <label for="description" class="strong">Bio (optional):</label>
                <textarea name="description" id="description" class="form-control">"""),_display_(/*48.85*/account/*48.92*/.description),format.raw/*48.104*/("""</textarea>
                <span id="error-description" class="error"></span>
              </fieldset>
            </div>
            <div class="col-md-6">
              <fieldset class="form-group">
                <label for="avatar" class="strong">Image (optional):</label>
                """),_display_(/*55.18*/gitbucket/*55.27*/.core.helper.html.uploadavatar(Some(account))),format.raw/*55.72*/("""
              """),format.raw/*56.15*/("""</fieldset>
            </div>
          </div>
        </div>
      </div>
      <div>
        <div class="pull-right">
          <a href=""""),_display_(/*63.21*/context/*63.28*/.path),format.raw/*63.33*/("""/"""),_display_(/*63.35*/account/*63.42*/.userName),format.raw/*63.51*/("""/_delete" class="btn btn-danger" id="delete">Delete account</a>
        </div>
        <input type="submit" class="btn btn-success" value="Save" id="save"/>
      </div>
    </form>
  """)))}),format.raw/*68.4*/("""
""")))}),format.raw/*69.2*/("""
"""),format.raw/*70.1*/("""<script>
$(function()"""),format.raw/*71.13*/("""{"""),format.raw/*71.14*/("""
  """),format.raw/*72.3*/("""addExtraMailAddress();
  $('#extraMailAddresses').on('change', '.extraMailAddress', checkExtraMailAddress);
  $('#save').click(function()"""),format.raw/*74.30*/("""{"""),format.raw/*74.31*/("""
    """),format.raw/*75.5*/("""let pwval = $('#password').val();
    if(typeof(pwval) != 'undefined' && pwval != '')"""),format.raw/*76.52*/("""{"""),format.raw/*76.53*/("""
      """),format.raw/*77.7*/("""return confirm('Are you sure you want to change password?');
    """),format.raw/*78.5*/("""}"""),format.raw/*78.6*/(""" """),format.raw/*78.7*/("""else """),format.raw/*78.12*/("""{"""),format.raw/*78.13*/("""
      """),format.raw/*79.7*/("""return true;
    """),format.raw/*80.5*/("""}"""),format.raw/*80.6*/("""
  """),format.raw/*81.3*/("""}"""),format.raw/*81.4*/(""");

  $('#delete').click(function()"""),format.raw/*83.32*/("""{"""),format.raw/*83.33*/("""
    """),format.raw/*84.5*/("""return confirm('Once you delete your account, there is no going back.\nAre you sure?');
  """),format.raw/*85.3*/("""}"""),format.raw/*85.4*/(""");
"""),format.raw/*86.1*/("""}"""),format.raw/*86.2*/(""");
</script>
"""))
      }
    }
  }

  def render(account:gitbucket.core.model.Account,extraMailAddresses:List[String],info:Option[Any],error:Option[Any],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,extraMailAddresses,info,error)(context)

  def f:((gitbucket.core.model.Account,List[String],Option[Any],Option[Any]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,extraMailAddresses,info,error) => (context) => apply(account,extraMailAddresses,info,error)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/account/edit.scala.html
                  HASH: 137f1b268b77f93d349946e46f0f8e14535f9871
                  MATRIX: 675->1|913->168|956->205|1019->241|1036->250|1080->286|1118->287|1147->291|1164->300|1248->376|1286->377|1317->383|1334->392|1389->427|1420->433|1437->442|1487->472|1559->518|1597->519|1714->592|1745->597|1786->612|1801->619|1843->641|2164->935|2203->936|2248->953|2693->1354|2736->1369|2959->1565|2976->1572|3007->1581|3392->1938|3423->1940|3440->1947|3490->1960|3768->2211|3795->2229|3821->2246|3881->2268|3928->2287|4000->2332|4024->2335|4078->2362|4102->2365|4179->2414|4205->2418|4327->2513|4351->2516|4423->2557|4466->2572|4705->2784|4721->2791|4746->2795|5070->3092|5086->3099|5120->3111|5444->3408|5462->3417|5528->3462|5571->3477|5739->3618|5755->3625|5781->3630|5810->3632|5826->3639|5856->3648|6071->3833|6103->3835|6131->3836|6180->3857|6209->3858|6239->3861|6404->3998|6433->3999|6465->4004|6578->4089|6607->4090|6641->4097|6733->4162|6761->4163|6789->4164|6822->4169|6851->4170|6885->4177|6929->4194|6957->4195|6987->4198|7015->4199|7078->4234|7107->4235|7139->4240|7256->4330|7284->4331|7314->4334|7342->4335
                  LINES: 14->1|17->2|18->3|21->4|21->4|21->4|21->4|22->5|22->5|22->5|22->5|23->6|23->6|23->6|24->7|24->7|24->7|25->8|25->8|25->8|26->9|26->9|26->9|26->9|32->15|32->15|33->16|40->23|41->24|43->26|43->26|43->26|48->31|48->31|48->31|48->31|53->36|53->36|53->36|53->36|54->37|54->37|54->37|54->37|54->37|54->37|54->37|55->38|55->38|56->39|57->40|60->43|60->43|60->43|65->48|65->48|65->48|72->55|72->55|72->55|73->56|80->63|80->63|80->63|80->63|80->63|80->63|85->68|86->69|87->70|88->71|88->71|89->72|91->74|91->74|92->75|93->76|93->76|94->77|95->78|95->78|95->78|95->78|95->78|96->79|97->80|97->80|98->81|98->81|100->83|100->83|101->84|102->85|102->85|103->86|103->86
                  -- GENERATED --
              */
          