
package gitbucket.core.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object goget extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta name="go-import" content=""""),_display_(/*5.38*/context/*5.45*/.baseUrl.replaceFirst("^https?://", "")),format.raw/*5.84*/("""/"""),_display_(/*5.86*/repository/*5.96*/.owner),format.raw/*5.102*/("""/"""),_display_(/*5.104*/repository/*5.114*/.name),format.raw/*5.119*/(""" """),format.raw/*5.120*/("""git """),_display_(/*5.125*/repository/*5.135*/.httpUrl),format.raw/*5.143*/("""" />
  </head>
</html>"""))
      }
    }
  }

  def render(repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(repository)(context)

  def f:((gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (repository) => (context) => apply(repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/goget.scala.html
                  HASH: 59aa51534c270b2734d9791b9238ad0809a437d6
                  MATRIX: 658->1|874->124|969->193|984->200|1043->239|1071->241|1089->251|1116->257|1145->259|1164->269|1190->274|1219->275|1251->280|1270->290|1299->298
                  LINES: 14->1|19->2|22->5|22->5|22->5|22->5|22->5|22->5|22->5|22->5|22->5|22->5|22->5|22->5|22->5
                  -- GENERATED --
              */
          