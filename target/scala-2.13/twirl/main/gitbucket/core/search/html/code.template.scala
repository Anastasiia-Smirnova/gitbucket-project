
package gitbucket.core.search.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object code extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[List[gitbucket.core.service.RepositorySearchService.FileSearchResult],String,Int,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(files: List[gitbucket.core.service.RepositorySearchService.FileSearchResult],
  query: String,
  page: Int,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*5.2*/import gitbucket.core.view.helpers
/*6.2*/import gitbucket.core.service.RepositorySearchService


Seq[Any](_display_(/*7.2*/gitbucket/*7.11*/.core.html.main("Search Results", Some(repository))/*7.62*/{_display_(Seq[Any](format.raw/*7.63*/("""
  """),_display_(/*8.4*/gitbucket/*8.13*/.core.search.html.menu("files", query, repository)/*8.63*/{_display_(Seq[Any](format.raw/*8.64*/("""
    """),_display_(if(query.nonEmpty)/*9.24*/ {_display_(Seq[Any](format.raw/*9.26*/("""
      """),_display_(if(files.isEmpty)/*10.25*/ {_display_(Seq[Any](format.raw/*10.27*/("""
        """),format.raw/*11.9*/("""<h4>We couldn't find any code matching '"""),_display_(/*11.50*/query),format.raw/*11.55*/("""'</h4>
      """)))}else/*12.14*/{_display_(Seq[Any](format.raw/*12.15*/("""
        """),format.raw/*13.9*/("""<h4>We have found """),_display_(/*13.28*/files/*13.33*/.size),format.raw/*13.38*/(""" """),format.raw/*13.39*/("""code """),_display_(/*13.45*/helpers/*13.52*/.plural(files.size, "result")),format.raw/*13.81*/("""</h4>
      """)))}),format.raw/*14.8*/("""
    """)))} else {null} ),format.raw/*15.6*/("""
    """),_display_(/*16.6*/files/*16.11*/.drop((page - 1) * RepositorySearchService.CodeLimit).take(RepositorySearchService.CodeLimit).map/*16.108*/ { file =>_display_(Seq[Any](format.raw/*16.118*/("""
      """),format.raw/*17.7*/("""<div>
        <h5><a href=""""),_display_(/*18.23*/helpers/*18.30*/.url(repository)),format.raw/*18.46*/("""/blob/"""),_display_(/*18.53*/repository/*18.63*/.repository.defaultBranch),format.raw/*18.88*/("""/"""),_display_(/*18.90*/file/*18.94*/.path),format.raw/*18.99*/("""">"""),_display_(/*18.102*/file/*18.106*/.path),format.raw/*18.111*/("""</a></h5>
        <div class="small muted">Last committed """),_display_(/*19.50*/gitbucket/*19.59*/.core.helper.html.datetimeago(file.lastModified)),format.raw/*19.107*/("""</div>
        <pre class="prettyprint linenums:"""),_display_(/*20.43*/file/*20.47*/.highlightLineNumber),format.raw/*20.67*/("""" style="padding-left: 25px;">"""),_display_(/*20.98*/Html(file.highlightText)),format.raw/*20.122*/("""</pre>
      </div>
    """)))}),format.raw/*22.6*/("""
    """),_display_(/*23.6*/gitbucket/*23.15*/.core.helper.html.paginator(page, files.size, RepositorySearchService.CodeLimit, 10,
      s"${helpers.url(repository)}/search?q=${helpers.urlEncode(query)}&type=code")),format.raw/*24.84*/("""
  """)))}),format.raw/*25.4*/("""
""")))}))
      }
    }
  }

  def render(files:List[gitbucket.core.service.RepositorySearchService.FileSearchResult],query:String,page:Int,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(files,query,page,repository)(context)

  def f:((List[gitbucket.core.service.RepositorySearchService.FileSearchResult],String,Int,gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (files,query,page,repository) => (context) => apply(files,query,page,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/search/code.scala.html
                  HASH: deeb1b6572838d094d6f971d95267cb61ed23fb6
                  MATRIX: 745->1|1050->235|1092->271|1174->326|1191->335|1250->386|1288->387|1317->391|1334->400|1392->450|1430->451|1480->475|1519->477|1571->502|1611->504|1647->513|1715->554|1741->559|1778->579|1817->580|1853->589|1899->608|1913->613|1939->618|1968->619|2001->625|2017->632|2067->661|2110->674|2159->680|2191->686|2205->691|2312->788|2361->798|2395->805|2450->833|2466->840|2503->856|2537->863|2556->873|2602->898|2631->900|2644->904|2670->909|2701->912|2715->916|2742->921|2828->980|2846->989|2916->1037|2992->1086|3005->1090|3046->1110|3104->1141|3150->1165|3205->1190|3237->1196|3255->1205|3444->1373|3478->1377
                  LINES: 14->1|20->5|21->6|24->7|24->7|24->7|24->7|25->8|25->8|25->8|25->8|26->9|26->9|27->10|27->10|28->11|28->11|28->11|29->12|29->12|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|31->14|32->15|33->16|33->16|33->16|33->16|34->17|35->18|35->18|35->18|35->18|35->18|35->18|35->18|35->18|35->18|35->18|35->18|35->18|36->19|36->19|36->19|37->20|37->20|37->20|37->20|37->20|39->22|40->23|40->23|41->24|42->25
                  -- GENERATED --
              */
          