
package gitbucket.core.helper.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object repositoryicon extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repository: gitbucket.core.service.RepositoryService.RepositoryInfo, large: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(if(repository.repository.isPrivate)/*2.37*/{_display_(Seq[Any](format.raw/*2.38*/("""
  """),format.raw/*3.3*/("""<i class=""""),_display_(/*3.14*/{if(large){"mega-"}}),format.raw/*3.34*/("""octicon octicon-lock"></i>
""")))}else/*4.8*/{_display_(Seq[Any](format.raw/*4.9*/("""
  """),_display_(if(repository.repository.originUserName.isDefined)/*5.54*/{_display_(Seq[Any](format.raw/*5.55*/("""
    """),format.raw/*6.5*/("""<i class=""""),_display_(/*6.16*/{if(large){"mega-"}}),format.raw/*6.36*/("""octicon octicon-repo-forked"></i>
  """)))}else/*7.10*/{_display_(Seq[Any](format.raw/*7.11*/("""
    """),format.raw/*8.5*/("""<i class=""""),_display_(/*8.16*/{if(large){"mega-"}}),format.raw/*8.36*/("""octicon octicon-repo"></i>
  """)))}),format.raw/*9.4*/("""
""")))}),format.raw/*10.2*/("""
"""))
      }
    }
  }

  def render(repository:gitbucket.core.service.RepositoryService.RepositoryInfo,large:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(repository,large)(context)

  def f:((gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (repository,large) => (context) => apply(repository,large)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/helper/repositoryicon.scala.html
                  HASH: 326ebb1becc601f6f820c0c31380a319141a361b
                  MATRIX: 682->1|950->176|988->177|1017->180|1054->191|1094->211|1143->245|1180->246|1260->300|1298->301|1329->306|1366->317|1406->337|1465->380|1503->381|1534->386|1571->397|1611->417|1670->447|1702->449
                  LINES: 14->1|19->2|19->2|20->3|20->3|20->3|21->4|21->4|22->5|22->5|23->6|23->6|23->6|24->7|24->7|25->8|25->8|25->8|26->9|27->10
                  -- GENERATED --
              */
          