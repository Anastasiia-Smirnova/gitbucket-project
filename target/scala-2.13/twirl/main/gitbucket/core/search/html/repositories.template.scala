
package gitbucket.core.search.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object repositories extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[String,List[gitbucket.core.service.RepositoryService.RepositoryInfo],List[gitbucket.core.service.RepositoryService.RepositoryInfo],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(query: String,
  repositories: List[gitbucket.core.service.RepositoryService.RepositoryInfo],
  recentRepositories: List[gitbucket.core.service.RepositoryService.RepositoryInfo])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*4.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*5.2*/gitbucket/*5.11*/.core.html.main("GitBucket")/*5.39*/{_display_(Seq[Any](format.raw/*5.40*/("""
  """),_display_(/*6.4*/gitbucket/*6.13*/.core.dashboard.html.sidebar(recentRepositories)/*6.61*/{_display_(Seq[Any](format.raw/*6.62*/("""
    """),format.raw/*7.5*/("""<form action=""""),_display_(/*7.20*/context/*7.27*/.path),format.raw/*7.32*/("""/search" method="GET" class="form-inline">
      <input type="text" name="query" value=""""),_display_(/*8.47*/query),format.raw/*8.52*/("""" class="form-control" style="width: 250px; margin-bottom: 0px;"/>
      <input type="submit" value="Search" class="btn btn-default"/>
    </form>
    """),_display_(if(repositories.isEmpty)/*11.30*/ {_display_(Seq[Any](format.raw/*11.32*/("""
      """),format.raw/*12.7*/("""<h4>We couldn't find any repositories matching '"""),_display_(/*12.56*/query),format.raw/*12.61*/("""'</h4>
    """)))}else/*13.12*/{_display_(Seq[Any](format.raw/*13.13*/("""
      """),format.raw/*14.7*/("""<h4>We've found """),_display_(/*14.24*/repositories/*14.36*/.size),format.raw/*14.41*/(""" """),_display_(/*14.43*/helpers/*14.50*/.plural(repositories.size, "repository", "repositories")),format.raw/*14.106*/("""</h4>
    """)))}),format.raw/*15.6*/("""
    """),_display_(/*16.6*/repositories/*16.18*/.map/*16.22*/ { repository =>_display_(Seq[Any](format.raw/*16.38*/("""
      """),format.raw/*17.7*/("""<div class="block">
        <div class="repository-icon">
          """),_display_(/*19.12*/gitbucket/*19.21*/.core.helper.html.repositoryicon(repository, true)),format.raw/*19.71*/("""
        """),format.raw/*20.9*/("""</div>
        <div class="repository-content">
          <div class="block-header">
            <a href=""""),_display_(/*23.23*/helpers/*23.30*/.url(repository)),format.raw/*23.46*/("""">"""),_display_(/*23.49*/repository/*23.59*/.owner),format.raw/*23.65*/("""/"""),_display_(/*23.67*/repository/*23.77*/.name),format.raw/*23.82*/("""</a>
            """),_display_(if(repository.repository.isPrivate)/*24.49*/{_display_(Seq[Any](format.raw/*24.50*/("""
              """),format.raw/*25.15*/("""<i class="octicon octicon-lock"></i>
            """)))} else {null} ),format.raw/*26.14*/("""
          """),format.raw/*27.11*/("""</div>
          """),_display_(if(repository.repository.originUserName.isDefined)/*28.62*/{_display_(Seq[Any](format.raw/*28.63*/("""
            """),format.raw/*29.13*/("""<div class="small muted">forked from <a href=""""),_display_(/*29.60*/context/*29.67*/.path),format.raw/*29.72*/("""/"""),_display_(/*29.74*/repository/*29.84*/.repository.parentUserName),format.raw/*29.110*/("""/"""),_display_(/*29.112*/repository/*29.122*/.repository.parentRepositoryName),format.raw/*29.154*/("""">"""),_display_(/*29.157*/repository/*29.167*/.repository.parentUserName),format.raw/*29.193*/("""/"""),_display_(/*29.195*/repository/*29.205*/.repository.parentRepositoryName),format.raw/*29.237*/("""</a></div>
          """)))} else {null} ),format.raw/*30.12*/("""
          """),_display_(if(repository.repository.description.isDefined)/*31.59*/{_display_(Seq[Any](format.raw/*31.60*/("""
            """),format.raw/*32.13*/("""<div>"""),_display_(/*32.19*/repository/*32.29*/.repository.description),format.raw/*32.52*/("""</div>
          """)))} else {null} ),format.raw/*33.12*/("""
          """),format.raw/*34.11*/("""<div><span class="muted small">Updated """),_display_(/*34.51*/gitbucket/*34.60*/.core.helper.html.datetimeago(repository.repository.lastActivityDate)),format.raw/*34.129*/("""</span></div>
        </div>
      </div>
    """)))}),format.raw/*37.6*/("""
  """)))}),format.raw/*38.4*/("""
""")))}),format.raw/*39.2*/("""
"""))
      }
    }
  }

  def render(query:String,repositories:List[gitbucket.core.service.RepositoryService.RepositoryInfo],recentRepositories:List[gitbucket.core.service.RepositoryService.RepositoryInfo],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(query,repositories,recentRepositories)(context)

  def f:((String,List[gitbucket.core.service.RepositoryService.RepositoryInfo],List[gitbucket.core.service.RepositoryService.RepositoryInfo]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (query,repositories,recentRepositories) => (context) => apply(query,repositories,recentRepositories)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/search/repositories.scala.html
                  HASH: 6a8482415457608e52176b4c7284d0721637c90a
                  MATRIX: 747->1|1052->235|1115->271|1132->280|1168->308|1206->309|1235->313|1252->322|1308->370|1346->371|1377->376|1418->391|1433->398|1458->403|1573->492|1598->497|1801->673|1841->675|1875->682|1951->731|1977->736|2012->754|2051->755|2085->762|2129->779|2150->791|2176->796|2205->798|2221->805|2299->861|2340->872|2372->878|2393->890|2406->894|2460->910|2494->917|2590->986|2608->995|2679->1045|2715->1054|2849->1161|2865->1168|2902->1184|2932->1187|2951->1197|2978->1203|3007->1205|3026->1215|3052->1220|3132->1273|3171->1274|3214->1289|3308->1339|3347->1350|3442->1418|3481->1419|3522->1432|3596->1479|3612->1486|3638->1491|3667->1493|3686->1503|3734->1529|3764->1531|3784->1541|3838->1573|3869->1576|3889->1586|3937->1612|3967->1614|3987->1624|4041->1656|4107->1678|4193->1737|4232->1738|4273->1751|4306->1757|4325->1767|4369->1790|4431->1808|4470->1819|4537->1859|4555->1868|4646->1937|4723->1984|4757->1988|4789->1990
                  LINES: 14->1|19->4|22->5|22->5|22->5|22->5|23->6|23->6|23->6|23->6|24->7|24->7|24->7|24->7|25->8|25->8|28->11|28->11|29->12|29->12|29->12|30->13|30->13|31->14|31->14|31->14|31->14|31->14|31->14|31->14|32->15|33->16|33->16|33->16|33->16|34->17|36->19|36->19|36->19|37->20|40->23|40->23|40->23|40->23|40->23|40->23|40->23|40->23|40->23|41->24|41->24|42->25|43->26|44->27|45->28|45->28|46->29|46->29|46->29|46->29|46->29|46->29|46->29|46->29|46->29|46->29|46->29|46->29|46->29|46->29|46->29|46->29|47->30|48->31|48->31|49->32|49->32|49->32|49->32|50->33|51->34|51->34|51->34|51->34|54->37|55->38|56->39
                  -- GENERATED --
              */
          