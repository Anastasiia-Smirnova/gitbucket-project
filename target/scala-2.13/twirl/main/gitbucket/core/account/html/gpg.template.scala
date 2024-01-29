
package gitbucket.core.account.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object gpg extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[gitbucket.core.model.Account,List[gitbucket.core.model.GpgKey],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: gitbucket.core.model.Account, gpgKeys: List[gitbucket.core.model.GpgKey])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import gitbucket.core.ssh.SshUtil


Seq[Any](_display_(/*3.2*/gitbucket/*3.11*/.core.html.main("GPG Keys")/*3.38*/{_display_(Seq[Any](format.raw/*3.39*/("""
  """),_display_(/*4.4*/gitbucket/*4.13*/.core.account.html.menu("gpg", context.loginAccount.get.userName, false)/*4.85*/{_display_(Seq[Any](format.raw/*4.86*/("""
    """),format.raw/*5.5*/("""<div class="panel panel-default">
      <div class="panel-heading strong">GPG Keys</div>
      <div class="panel-body">
        """),_display_(if(gpgKeys.isEmpty)/*8.29*/{_display_(Seq[Any](format.raw/*8.30*/("""
          """),format.raw/*9.11*/("""No keys
        """)))} else {null} ),format.raw/*10.10*/("""
        """),_display_(/*11.10*/gpgKeys/*11.17*/.zipWithIndex.map/*11.34*/ { case (key, i) =>_display_(Seq[Any](format.raw/*11.53*/("""
          """),_display_(if(i != 0)/*12.22*/{_display_(Seq[Any](format.raw/*12.23*/("""
            """),format.raw/*13.13*/("""<hr>
          """)))} else {null} ),format.raw/*14.12*/("""
        """),format.raw/*15.9*/("""<strong style="line-height: 30px;">"""),_display_(/*15.45*/key/*15.48*/.title),format.raw/*15.54*/("""</strong> ("""),_display_(/*15.66*/key/*15.69*/.gpgKeyId.toHexString.toUpperCase),format.raw/*15.102*/(""")
        <a href=""""),_display_(/*16.19*/context/*16.26*/.path),format.raw/*16.31*/("""/"""),_display_(/*16.33*/account/*16.40*/.userName),format.raw/*16.49*/("""/_gpg/delete/"""),_display_(/*16.63*/key/*16.66*/.keyId),format.raw/*16.72*/("""" class="btn btn-sm btn-danger pull-right">Delete</a>
        """)))}),format.raw/*17.10*/("""
      """),format.raw/*18.7*/("""</div>
    </div>
    <form method="POST" action=""""),_display_(/*20.34*/context/*20.41*/.path),format.raw/*20.46*/("""/"""),_display_(/*20.48*/account/*20.55*/.userName),format.raw/*20.64*/("""/_gpg" validate="true" autocomplete="off">
      <div class="panel panel-default">
        <div class="panel-heading strong">Add a GPG Key</div>
        <div class="panel-body">
          <fieldset class="form-group">
            <label for="title" class="strong">Title</label>
            <div><span id="error-title" class="error"></span></div>
            <input type="text" name="title" id="title" class="form-control"/>
          </fieldset>
          <fieldset class="form-group">
            <label for="publicKey" class="strong">Key</label>
            <div><span id="error-publicKey" class="error"></span></div>
            <textarea name="publicKey" id="publicKey" class="form-control" style="height: 200px;"></textarea>
          </fieldset>
          <input type="submit" class="btn btn-success" value="Add"/>
        </div>
      </div>
    </form>
  """)))}),format.raw/*38.4*/("""
""")))}),format.raw/*39.2*/("""
"""))
      }
    }
  }

  def render(account:gitbucket.core.model.Account,gpgKeys:List[gitbucket.core.model.GpgKey],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,gpgKeys)(context)

  def f:((gitbucket.core.model.Account,List[gitbucket.core.model.GpgKey]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,gpgKeys) => (context) => apply(account,gpgKeys)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/account/gpg.scala.html
                  HASH: 5bf1b852752eba4abd965a179ba92e5c248e9b73
                  MATRIX: 671->1|880->139|942->174|959->183|994->210|1032->211|1061->215|1078->224|1158->296|1196->297|1227->302|1401->450|1439->451|1477->462|1538->479|1575->489|1591->496|1617->513|1674->532|1723->554|1762->555|1803->568|1863->584|1899->593|1962->629|1974->632|2001->638|2040->650|2052->653|2107->686|2154->706|2170->713|2196->718|2225->720|2241->727|2271->736|2312->750|2324->753|2351->759|2445->822|2479->829|2557->880|2573->887|2599->892|2628->894|2644->901|2674->910|3568->1774|3600->1776
                  LINES: 14->1|17->2|20->3|20->3|20->3|20->3|21->4|21->4|21->4|21->4|22->5|25->8|25->8|26->9|27->10|28->11|28->11|28->11|28->11|29->12|29->12|30->13|31->14|32->15|32->15|32->15|32->15|32->15|32->15|32->15|33->16|33->16|33->16|33->16|33->16|33->16|33->16|33->16|33->16|34->17|35->18|37->20|37->20|37->20|37->20|37->20|37->20|55->38|56->39
                  -- GENERATED --
              */
          