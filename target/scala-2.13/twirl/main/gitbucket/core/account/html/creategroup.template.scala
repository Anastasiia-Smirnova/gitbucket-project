
package gitbucket.core.account.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object creategroup extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[List[gitbucket.core.model.GroupMember],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(members: List[gitbucket.core.model.GroupMember])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/gitbucket/*2.11*/.core.html.main("Create group")/*2.42*/{_display_(Seq[Any](format.raw/*2.43*/("""
  """),format.raw/*3.3*/("""<div class="content-wrapper main-center">
    <div class="content body">
      <h2>Create group</h2>
      <form id="form" method="post" action=""""),_display_(/*6.46*/context/*6.53*/.path),format.raw/*6.58*/("""/groups/new" validate="true">
        """),_display_(/*7.10*/gitbucket/*7.19*/.core.account.html.groupform(None, members, false)),format.raw/*7.69*/("""
        """),format.raw/*8.9*/("""<fieldset class="border-top">
          <input type="submit" class="btn btn-success" value="Create group"/>
        </fieldset>
      </form>
    </div>
  </div>
""")))}),format.raw/*14.2*/("""
"""))
      }
    }
  }

  def render(members:List[gitbucket.core.model.GroupMember],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(members)(context)

  def f:((List[gitbucket.core.model.GroupMember]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (members) => (context) => apply(members)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/account/creategroup.scala.html
                  HASH: 84123b171cf775eb004086a216915fb33ed9cb2b
                  MATRIX: 655->1|851->105|868->114|907->145|945->146|974->149|1146->295|1161->302|1186->307|1251->346|1268->355|1338->405|1373->414|1566->577
                  LINES: 14->1|19->2|19->2|19->2|19->2|20->3|23->6|23->6|23->6|24->7|24->7|24->7|25->8|31->14
                  -- GENERATED --
              */
          