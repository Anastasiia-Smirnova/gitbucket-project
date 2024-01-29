
package gitbucket.core.account.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object ssh extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[gitbucket.core.model.Account,List[gitbucket.core.model.SshKey],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: gitbucket.core.model.Account, sshKeys: List[gitbucket.core.model.SshKey])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import gitbucket.core.ssh.SshUtil


Seq[Any](_display_(/*3.2*/gitbucket/*3.11*/.core.html.main("SSH Keys")/*3.38*/{_display_(Seq[Any](format.raw/*3.39*/("""
  """),_display_(/*4.4*/gitbucket/*4.13*/.core.account.html.menu("ssh", context.loginAccount.get.userName, false)/*4.85*/{_display_(Seq[Any](format.raw/*4.86*/("""
    """),format.raw/*5.5*/("""<div class="panel panel-default">
      <div class="panel-heading strong">SSH Keys</div>
      <div class="panel-body">
        """),_display_(if(sshKeys.isEmpty)/*8.29*/{_display_(Seq[Any](format.raw/*8.30*/("""
          """),format.raw/*9.11*/("""No keys
        """)))} else {null} ),format.raw/*10.10*/("""
        """),_display_(/*11.10*/sshKeys/*11.17*/.zipWithIndex.map/*11.34*/ { case (key, i) =>_display_(Seq[Any](format.raw/*11.53*/("""
          """),_display_(if(i != 0)/*12.22*/{_display_(Seq[Any](format.raw/*12.23*/("""
            """),format.raw/*13.13*/("""<hr>
          """)))} else {null} ),format.raw/*14.12*/("""
          """),format.raw/*15.11*/("""<strong style="line-height: 30px;">"""),_display_(/*15.47*/key/*15.50*/.title),format.raw/*15.56*/("""</strong> ("""),_display_(/*15.68*/SshUtil/*15.75*/.fingerPrint(key.publicKey).getOrElse("Key is invalid.")),format.raw/*15.131*/(""")
          <a href=""""),_display_(/*16.21*/context/*16.28*/.path),format.raw/*16.33*/("""/"""),_display_(/*16.35*/account/*16.42*/.userName),format.raw/*16.51*/("""/_ssh/delete/"""),_display_(/*16.65*/key/*16.68*/.sshKeyId),format.raw/*16.77*/("""" class="btn btn-sm btn-danger pull-right">Delete</a>
        """)))}),format.raw/*17.10*/("""
      """),format.raw/*18.7*/("""</div>
    </div>
    <form method="POST" action=""""),_display_(/*20.34*/context/*20.41*/.path),format.raw/*20.46*/("""/"""),_display_(/*20.48*/account/*20.55*/.userName),format.raw/*20.64*/("""/_ssh" validate="true" autocomplete="off">
      <div class="panel panel-default">
        <div class="panel-heading strong">Add a public SSH Key</div>
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

  def render(account:gitbucket.core.model.Account,sshKeys:List[gitbucket.core.model.SshKey],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,sshKeys)(context)

  def f:((gitbucket.core.model.Account,List[gitbucket.core.model.SshKey]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,sshKeys) => (context) => apply(account,sshKeys)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/account/ssh.scala.html
                  HASH: 8a4f750eeb5c172d4b4261d554bcdbe489c621e4
                  MATRIX: 671->1|880->139|942->174|959->183|994->210|1032->211|1061->215|1078->224|1158->296|1196->297|1227->302|1401->450|1439->451|1477->462|1538->479|1575->489|1591->496|1617->513|1674->532|1723->554|1762->555|1803->568|1863->584|1902->595|1965->631|1977->634|2004->640|2043->652|2059->659|2137->715|2186->737|2202->744|2228->749|2257->751|2273->758|2303->767|2344->781|2356->784|2386->793|2480->856|2514->863|2592->914|2608->921|2634->926|2663->928|2679->935|2709->944|3610->1815|3642->1817
                  LINES: 14->1|17->2|20->3|20->3|20->3|20->3|21->4|21->4|21->4|21->4|22->5|25->8|25->8|26->9|27->10|28->11|28->11|28->11|28->11|29->12|29->12|30->13|31->14|32->15|32->15|32->15|32->15|32->15|32->15|32->15|33->16|33->16|33->16|33->16|33->16|33->16|33->16|33->16|33->16|34->17|35->18|37->20|37->20|37->20|37->20|37->20|37->20|55->38|56->39
                  -- GENERATED --
              */
          