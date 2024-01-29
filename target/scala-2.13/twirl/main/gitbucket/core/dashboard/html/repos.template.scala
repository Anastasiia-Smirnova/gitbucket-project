
package gitbucket.core.dashboard.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object repos extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[List[String],List[gitbucket.core.service.RepositoryService.RepositoryInfo],List[gitbucket.core.service.RepositoryService.RepositoryInfo],Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(groups: List[String],
  visibleRepositories: List[gitbucket.core.service.RepositoryService.RepositoryInfo],
  recentRepositories: List[gitbucket.core.service.RepositoryService.RepositoryInfo],
  enableNewsFeed: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*5.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*6.2*/gitbucket/*6.11*/.core.html.main("Repositories")/*6.42*/{_display_(Seq[Any](format.raw/*6.43*/("""
  """),_display_(/*7.4*/gitbucket/*7.13*/.core.dashboard.html.sidebar(recentRepositories)/*7.61*/{_display_(Seq[Any](format.raw/*7.62*/("""
    """),_display_(/*8.6*/gitbucket/*8.15*/.core.dashboard.html.tab(enableNewsFeed, "repos")),format.raw/*8.64*/("""
    """),format.raw/*9.5*/("""<div class="container">
      <div class="btn-group" id="owner-dropdown">
        <button class="dropdown-toggle btn btn-default" data-toggle="dropdown" aria-expanded="false">
          <span class="strong">All</span>
          <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
          <li><a href="javascript:void(0);" data-name=""><i class="octicon octicon-check"></i><span>All</span></a></li>
          """),_display_(/*17.12*/visibleRepositories/*17.31*/.map(_.owner).distinct.map/*17.57*/ { userName =>_display_(Seq[Any](format.raw/*17.71*/("""
            """),format.raw/*18.13*/("""<li><a href="javascript:void(0);" data-name=""""),_display_(/*18.59*/userName),format.raw/*18.67*/(""""><i class="octicon"></i><span>"""),_display_(/*18.99*/helpers/*18.106*/.avatar(userName, 20)),format.raw/*18.127*/(""" """),_display_(/*18.129*/userName),format.raw/*18.137*/("""</span></a></li>
          """)))}),format.raw/*19.12*/("""
        """),format.raw/*20.9*/("""</ul>
      </div>
      """),_display_(if(visibleRepositories.isEmpty)/*22.39*/{_display_(Seq[Any](format.raw/*22.40*/("""
        """),format.raw/*23.9*/("""No repositories
      """)))}else/*24.14*/{_display_(Seq[Any](format.raw/*24.15*/("""
        """),_display_(/*25.10*/visibleRepositories/*25.29*/.map/*25.33*/ { repository =>_display_(Seq[Any](format.raw/*25.49*/("""
          """),format.raw/*26.11*/("""<div class="block" data-owner=""""),_display_(/*26.43*/repository/*26.53*/.owner),format.raw/*26.59*/("""">
            <div class="repository-icon">
              """),_display_(/*28.16*/gitbucket/*28.25*/.core.helper.html.repositoryicon(repository, true)),format.raw/*28.75*/("""
            """),format.raw/*29.13*/("""</div>
            <div class="repository-content">
              <div class="block-header">
                <a href=""""),_display_(/*32.27*/helpers/*32.34*/.url(repository)),format.raw/*32.50*/("""">"""),_display_(/*32.53*/repository/*32.63*/.owner),format.raw/*32.69*/("""/"""),_display_(/*32.71*/repository/*32.81*/.name),format.raw/*32.86*/("""</a>
                """),_display_(if(repository.repository.isPrivate)/*33.53*/{_display_(Seq[Any](format.raw/*33.54*/("""
                  """),format.raw/*34.19*/("""<i class="octicon octicon-lock"></i>
                """)))} else {null} ),format.raw/*35.18*/("""
              """),format.raw/*36.15*/("""</div>
              """),_display_(if(repository.repository.originUserName.isDefined)/*37.66*/{_display_(Seq[Any](format.raw/*37.67*/("""
                """),format.raw/*38.17*/("""<div class="small muted">forked from <a href=""""),_display_(/*38.64*/context/*38.71*/.path),format.raw/*38.76*/("""/"""),_display_(/*38.78*/repository/*38.88*/.repository.parentUserName),format.raw/*38.114*/("""/"""),_display_(/*38.116*/repository/*38.126*/.repository.parentRepositoryName),format.raw/*38.158*/("""">"""),_display_(/*38.161*/repository/*38.171*/.repository.parentUserName),format.raw/*38.197*/("""/"""),_display_(/*38.199*/repository/*38.209*/.repository.parentRepositoryName),format.raw/*38.241*/("""</a></div>
              """)))} else {null} ),format.raw/*39.16*/("""
              """),_display_(if(repository.repository.description.isDefined)/*40.63*/{_display_(Seq[Any](format.raw/*40.64*/("""
                """),format.raw/*41.17*/("""<div>"""),_display_(/*41.23*/repository/*41.33*/.repository.description),format.raw/*41.56*/("""</div>
              """)))} else {null} ),format.raw/*42.16*/("""
              """),format.raw/*43.15*/("""<div><span class="muted small">Updated """),_display_(/*43.55*/gitbucket/*43.64*/.core.helper.html.datetimeago(repository.repository.lastActivityDate)),format.raw/*43.133*/("""</span></div>
            </div>
          </div>
        """)))}),format.raw/*46.10*/("""
      """)))}),format.raw/*47.8*/("""
    """),format.raw/*48.5*/("""</div>
  """)))}),format.raw/*49.4*/("""
""")))}),format.raw/*50.2*/("""
"""),format.raw/*51.1*/("""<script>
$('#owner-dropdown a').click(function()"""),format.raw/*52.40*/("""{"""),format.raw/*52.41*/("""
  """),format.raw/*53.3*/("""var userName = $(this).data('name');

  $('#owner-dropdown i').attr('class', 'octicon');
  $(this).find('i').attr('class', 'octicon octicon-check');

  $('#owner-dropdown span.strong').html($(this).find('span').html());

  $('div.block').each(function(i, e)"""),format.raw/*60.37*/("""{"""),format.raw/*60.38*/("""
    """),format.raw/*61.5*/("""if(userName == '')"""),format.raw/*61.23*/("""{"""),format.raw/*61.24*/("""
      """),format.raw/*62.7*/("""$(e).show();
    """),format.raw/*63.5*/("""}"""),format.raw/*63.6*/(""" """),format.raw/*63.7*/("""else """),format.raw/*63.12*/("""{"""),format.raw/*63.13*/("""
      """),format.raw/*64.7*/("""if($(e).data('owner') == userName)"""),format.raw/*64.41*/("""{"""),format.raw/*64.42*/("""
        """),format.raw/*65.9*/("""$(e).show();
      """),format.raw/*66.7*/("""}"""),format.raw/*66.8*/(""" """),format.raw/*66.9*/("""else """),format.raw/*66.14*/("""{"""),format.raw/*66.15*/("""
        """),format.raw/*67.9*/("""$(e).hide();
      """),format.raw/*68.7*/("""}"""),format.raw/*68.8*/("""
    """),format.raw/*69.5*/("""}"""),format.raw/*69.6*/("""
  """),format.raw/*70.3*/("""}"""),format.raw/*70.4*/(""");
"""),format.raw/*71.1*/("""}"""),format.raw/*71.2*/(""");
</script>
"""))
      }
    }
  }

  def render(groups:List[String],visibleRepositories:List[gitbucket.core.service.RepositoryService.RepositoryInfo],recentRepositories:List[gitbucket.core.service.RepositoryService.RepositoryInfo],enableNewsFeed:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(groups,visibleRepositories,recentRepositories,enableNewsFeed)(context)

  def f:((List[String],List[gitbucket.core.service.RepositoryService.RepositoryInfo],List[gitbucket.core.service.RepositoryService.RepositoryInfo],Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (groups,visibleRepositories,recentRepositories,enableNewsFeed) => (context) => apply(groups,visibleRepositories,recentRepositories,enableNewsFeed)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/dashboard/repos.scala.html
                  HASH: bcbc901081dce8073a12b2502f2cf47708efd032
                  MATRIX: 757->1|1103->276|1166->312|1183->321|1222->352|1260->353|1289->357|1306->366|1362->414|1400->415|1431->421|1448->430|1517->479|1548->484|2015->924|2043->943|2078->969|2130->983|2171->996|2244->1042|2273->1050|2332->1082|2349->1089|2392->1110|2422->1112|2452->1120|2511->1148|2547->1157|2631->1214|2670->1215|2706->1224|2752->1253|2791->1254|2828->1264|2856->1283|2869->1287|2923->1303|2962->1314|3021->1346|3040->1356|3067->1362|3154->1422|3172->1431|3243->1481|3284->1494|3430->1613|3446->1620|3483->1636|3513->1639|3532->1649|3559->1655|3588->1657|3607->1667|3633->1672|3717->1729|3756->1730|3803->1749|3901->1803|3944->1818|4043->1890|4082->1891|4127->1908|4201->1955|4217->1962|4243->1967|4272->1969|4291->1979|4339->2005|4369->2007|4389->2017|4443->2049|4474->2052|4494->2062|4542->2088|4572->2090|4592->2100|4646->2132|4716->2158|4806->2221|4845->2222|4890->2239|4923->2245|4942->2255|4986->2278|5052->2300|5095->2315|5162->2355|5180->2364|5271->2433|5361->2492|5399->2500|5431->2505|5471->2515|5503->2517|5531->2518|5607->2566|5636->2567|5666->2570|5951->2827|5980->2828|6012->2833|6058->2851|6087->2852|6121->2859|6165->2876|6193->2877|6221->2878|6254->2883|6283->2884|6317->2891|6379->2925|6408->2926|6444->2935|6490->2954|6518->2955|6546->2956|6579->2961|6608->2962|6644->2971|6690->2990|6718->2991|6750->2996|6778->2997|6808->3000|6836->3001|6866->3004|6894->3005
                  LINES: 14->1|20->5|23->6|23->6|23->6|23->6|24->7|24->7|24->7|24->7|25->8|25->8|25->8|26->9|34->17|34->17|34->17|34->17|35->18|35->18|35->18|35->18|35->18|35->18|35->18|35->18|36->19|37->20|39->22|39->22|40->23|41->24|41->24|42->25|42->25|42->25|42->25|43->26|43->26|43->26|43->26|45->28|45->28|45->28|46->29|49->32|49->32|49->32|49->32|49->32|49->32|49->32|49->32|49->32|50->33|50->33|51->34|52->35|53->36|54->37|54->37|55->38|55->38|55->38|55->38|55->38|55->38|55->38|55->38|55->38|55->38|55->38|55->38|55->38|55->38|55->38|55->38|56->39|57->40|57->40|58->41|58->41|58->41|58->41|59->42|60->43|60->43|60->43|60->43|63->46|64->47|65->48|66->49|67->50|68->51|69->52|69->52|70->53|77->60|77->60|78->61|78->61|78->61|79->62|80->63|80->63|80->63|80->63|80->63|81->64|81->64|81->64|82->65|83->66|83->66|83->66|83->66|83->66|84->67|85->68|85->68|86->69|86->69|87->70|87->70|88->71|88->71
                  -- GENERATED --
              */
          