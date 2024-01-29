
package gitbucket.core.search.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object wiki extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[List[gitbucket.core.service.RepositorySearchService.FileSearchResult],String,Int,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(wikis: List[gitbucket.core.service.RepositorySearchService.FileSearchResult],
  query: String,
  page: Int,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*5.2*/import gitbucket.core.view.helpers
/*6.2*/import gitbucket.core.service.RepositorySearchService


Seq[Any](_display_(/*7.2*/gitbucket/*7.11*/.core.html.main("Search Results", Some(repository))/*7.62*/{_display_(Seq[Any](format.raw/*7.63*/("""
  """),_display_(/*8.4*/gitbucket/*8.13*/.core.search.html.menu("wiki", query, repository)/*8.62*/{_display_(Seq[Any](format.raw/*8.63*/("""
    """),_display_(if(query.nonEmpty)/*9.24*/ {_display_(Seq[Any](format.raw/*9.26*/("""
      """),_display_(if(wikis.isEmpty)/*10.25*/ {_display_(Seq[Any](format.raw/*10.27*/("""
        """),format.raw/*11.9*/("""<h4>We could not find any pages matching '"""),_display_(/*11.52*/query),format.raw/*11.57*/("""'</h4>
      """)))}else/*12.14*/{_display_(Seq[Any](format.raw/*12.15*/("""
        """),format.raw/*13.9*/("""<h4>We've found """),_display_(/*13.26*/wikis/*13.31*/.size),format.raw/*13.36*/(""" """),_display_(/*13.38*/helpers/*13.45*/.plural(wikis.size, "page")),format.raw/*13.72*/("""</h4>
      """)))}),format.raw/*14.8*/("""
    """)))} else {null} ),format.raw/*15.6*/("""
    """),_display_(/*16.6*/wikis/*16.11*/.drop((page - 1) * RepositorySearchService.CodeLimit).take(RepositorySearchService.CodeLimit).map/*16.108*/ { file =>_display_(Seq[Any](format.raw/*16.118*/("""
      """),format.raw/*17.7*/("""<div>
        <h5><a href=""""),_display_(/*18.23*/helpers/*18.30*/.url(repository)),format.raw/*18.46*/("""/wiki/"""),_display_(/*18.53*/file/*18.57*/.path),format.raw/*18.62*/("""">"""),_display_(/*18.65*/file/*18.69*/.path),format.raw/*18.74*/("""</a></h5>
        <div class="small muted">Last committed """),_display_(/*19.50*/gitbucket/*19.59*/.core.helper.html.datetimeago(file.lastModified)),format.raw/*19.107*/("""</div>
        <pre class="prettyprint linenums:"""),_display_(/*20.43*/file/*20.47*/.highlightLineNumber),format.raw/*20.67*/("""" style="padding-left: 25px;">"""),_display_(/*20.98*/Html(file.highlightText)),format.raw/*20.122*/("""</pre>
      </div>
    """)))}),format.raw/*22.6*/("""
    """),_display_(/*23.6*/gitbucket/*23.15*/.core.helper.html.paginator(page, wikis.size, RepositorySearchService.CodeLimit, 10,
      s"${helpers.url(repository)}/search?q=${helpers.urlEncode(query)}&type=wiki")),format.raw/*24.84*/("""
  """)))}),format.raw/*25.4*/("""
""")))}),format.raw/*26.2*/("""
"""))
      }
    }
  }

  def render(wikis:List[gitbucket.core.service.RepositorySearchService.FileSearchResult],query:String,page:Int,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(wikis,query,page,repository)(context)

  def f:((List[gitbucket.core.service.RepositorySearchService.FileSearchResult],String,Int,gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (wikis,query,page,repository) => (context) => apply(wikis,query,page,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/search/wiki.scala.html
                  HASH: 5ea47f359faaa76227d96eed5eb84219bdbe3602
                  MATRIX: 745->1|1050->235|1092->271|1174->326|1191->335|1250->386|1288->387|1317->391|1334->400|1391->449|1429->450|1479->474|1518->476|1570->501|1610->503|1646->512|1716->555|1742->560|1779->580|1818->581|1854->590|1898->607|1912->612|1938->617|1967->619|1983->626|2031->653|2074->666|2123->672|2155->678|2169->683|2276->780|2325->790|2359->797|2414->825|2430->832|2467->848|2501->855|2514->859|2540->864|2570->867|2583->871|2609->876|2695->935|2713->944|2783->992|2859->1041|2872->1045|2913->1065|2971->1096|3017->1120|3072->1145|3104->1151|3122->1160|3311->1328|3345->1332|3377->1334
                  LINES: 14->1|20->5|21->6|24->7|24->7|24->7|24->7|25->8|25->8|25->8|25->8|26->9|26->9|27->10|27->10|28->11|28->11|28->11|29->12|29->12|30->13|30->13|30->13|30->13|30->13|30->13|30->13|31->14|32->15|33->16|33->16|33->16|33->16|34->17|35->18|35->18|35->18|35->18|35->18|35->18|35->18|35->18|35->18|36->19|36->19|36->19|37->20|37->20|37->20|37->20|37->20|39->22|40->23|40->23|41->24|42->25|43->26
                  -- GENERATED --
              */
          