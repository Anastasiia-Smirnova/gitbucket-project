
package gitbucket.core.wiki.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object pages extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[List[String],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(pages: List[String],
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  isEditable: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*4.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*5.2*/gitbucket/*5.11*/.core.html.main(s"Pages - ${repository.owner}/${repository.name}", Some(repository))/*5.95*/{_display_(Seq[Any](format.raw/*5.96*/("""
  """),_display_(/*6.4*/gitbucket/*6.13*/.core.html.menu("wiki", repository)/*6.48*/{_display_(Seq[Any](format.raw/*6.49*/("""
    """),format.raw/*7.5*/("""<div class="pull-right">
      """),_display_(if(isEditable)/*8.22*/{_display_(Seq[Any](format.raw/*8.23*/("""
        """),format.raw/*9.9*/("""<a class="btn btn-default" href=""""),_display_(/*9.43*/helpers/*9.50*/.url(repository)),format.raw/*9.66*/("""/wiki/_new">New Page</a>
      """)))} else {null} ),format.raw/*10.8*/("""
    """),format.raw/*11.5*/("""</div>
    <h1 class="body-title"><span class="muted">Pages</span></h1>
    <hr>
    <ul>
      """),_display_(/*15.8*/pages/*15.13*/.map/*15.17*/ { page =>_display_(Seq[Any](format.raw/*15.27*/("""
        """),format.raw/*16.9*/("""<li><a href=""""),_display_(/*16.23*/helpers/*16.30*/.url(repository)),format.raw/*16.46*/("""/wiki/"""),_display_(/*16.53*/helpers/*16.60*/.urlEncode(page)),format.raw/*16.76*/("""">"""),_display_(/*16.79*/page),format.raw/*16.83*/("""</a></li>
      """)))}),format.raw/*17.8*/("""
    """),format.raw/*18.5*/("""</ul>
  """)))}),format.raw/*19.4*/("""
""")))}),format.raw/*20.2*/("""
"""))
      }
    }
  }

  def render(pages:List[String],repository:gitbucket.core.service.RepositoryService.RepositoryInfo,isEditable:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(pages,repository,isEditable)(context)

  def f:((List[String],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (pages,repository,isEditable) => (context) => apply(pages,repository,isEditable)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/wiki/pages.scala.html
                  HASH: 055dad3ec7b6d0101c5208b6be9ba5044671ce26
                  MATRIX: 684->1|925->171|988->207|1005->216|1097->300|1135->301|1164->305|1181->314|1224->349|1262->350|1293->355|1365->401|1403->402|1438->411|1498->445|1513->452|1549->468|1624->500|1656->505|1779->602|1793->607|1806->611|1854->621|1890->630|1931->644|1947->651|1984->667|2018->674|2034->681|2071->697|2101->700|2126->704|2173->721|2205->726|2244->735|2276->737
                  LINES: 14->1|19->4|22->5|22->5|22->5|22->5|23->6|23->6|23->6|23->6|24->7|25->8|25->8|26->9|26->9|26->9|26->9|27->10|28->11|32->15|32->15|32->15|32->15|33->16|33->16|33->16|33->16|33->16|33->16|33->16|33->16|33->16|34->17|35->18|36->19|37->20
                  -- GENERATED --
              */
          