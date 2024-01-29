
package gitbucket.core.search.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object menu extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[String,String,gitbucket.core.service.RepositoryService.RepositoryInfo,Html,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(active: String, query: String,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(body: Html)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*4.2*/gitbucket/*4.11*/.core.html.menu(active, repository)/*4.46*/{_display_(Seq[Any](format.raw/*4.47*/("""
  """),format.raw/*5.3*/("""<form action=""""),_display_(/*5.18*/helpers/*5.25*/.url(repository)),format.raw/*5.41*/("""/search" method="GET" class="form-inline">
    <select class="form-control" name="type">
      <option value="code" """),_display_(if(active == "files")/*7.50*/{_display_(Seq[Any](format.raw/*7.51*/(""" """),format.raw/*7.52*/("""selected """)))} else {null} ),format.raw/*7.62*/(""">Files</option>
      """),_display_(if(repository.repository.options.issuesOption != "DISABLE")/*8.67*/ {_display_(Seq[Any](format.raw/*8.69*/("""
        """),format.raw/*9.9*/("""<option value="issues" """),_display_(if(active == "issues")/*9.55*/{_display_(Seq[Any](format.raw/*9.56*/(""" """),format.raw/*9.57*/("""selected """)))} else {null} ),format.raw/*9.67*/(""">Issues</option>
      """)))} else {null} ),format.raw/*10.8*/("""
      """),_display_(if(repository.repository.options.issuesOption != "DISABLE")/*11.67*/ {_display_(Seq[Any](format.raw/*11.69*/("""
        """),format.raw/*12.9*/("""<option value="pulls" """),_display_(if(active == "pulls")/*12.53*/{_display_(Seq[Any](format.raw/*12.54*/(""" """),format.raw/*12.55*/("""selected """)))} else {null} ),format.raw/*12.65*/(""">Pull requests</option>
      """)))} else {null} ),format.raw/*13.8*/("""
      """),_display_(if(repository.repository.options.wikiOption != "DISABLE")/*14.65*/ {_display_(Seq[Any](format.raw/*14.67*/("""
        """),format.raw/*15.9*/("""<option value="wiki" """),_display_(if(active == "wiki")/*15.51*/{_display_(Seq[Any](format.raw/*15.52*/(""" """),format.raw/*15.53*/("""selected """)))} else {null} ),format.raw/*15.63*/(""">Wiki</option>
      """)))} else {null} ),format.raw/*16.8*/("""
    """),format.raw/*17.5*/("""</select>
    <input type="text" name="q" value=""""),_display_(/*18.41*/query),format.raw/*18.46*/("""" class="form-control" style="width: 250px;" placeholder="Search..."/>
    <input type="submit" value="Search" class="btn btn-default"/>
    <input type="hidden" name="type" value=""""),_display_(/*20.46*/active),format.raw/*20.52*/(""""/>
  </form>
  """),_display_(/*22.4*/body),format.raw/*22.8*/("""
""")))}),format.raw/*23.2*/("""
"""))
      }
    }
  }

  def render(active:String,query:String,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,body:Html,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(active,query,repository)(body)(context)

  def f:((String,String,gitbucket.core.service.RepositoryService.RepositoryInfo) => (Html) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (active,query,repository) => (body) => (context) => apply(active,query,repository)(body)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/search/menu.scala.html
                  HASH: cd7ed1e02620178785819e5a8aed4cd2d6d369c7
                  MATRIX: 683->1|923->170|986->206|1003->215|1046->250|1084->251|1113->254|1154->269|1169->276|1205->292|1369->430|1407->431|1435->432|1488->442|1596->524|1635->526|1670->535|1742->581|1780->582|1808->583|1861->593|1928->617|2022->684|2062->686|2098->695|2169->739|2208->740|2237->741|2291->751|2365->782|2457->847|2497->849|2533->858|2602->900|2641->901|2670->902|2724->912|2789->934|2821->939|2898->989|2924->994|3133->1176|3160->1182|3203->1199|3227->1203|3259->1205
                  LINES: 14->1|18->3|21->4|21->4|21->4|21->4|22->5|22->5|22->5|22->5|24->7|24->7|24->7|24->7|25->8|25->8|26->9|26->9|26->9|26->9|26->9|27->10|28->11|28->11|29->12|29->12|29->12|29->12|29->12|30->13|31->14|31->14|32->15|32->15|32->15|32->15|32->15|33->16|34->17|35->18|35->18|37->20|37->20|39->22|39->22|40->23
                  -- GENERATED --
              */
          