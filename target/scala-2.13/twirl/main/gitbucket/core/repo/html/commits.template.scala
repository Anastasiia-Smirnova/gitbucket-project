
package gitbucket.core.repo.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object commits extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template8[List[String],String,gitbucket.core.service.RepositoryService.RepositoryInfo,Seq[Seq[(gitbucket.core.util.JGitUtil.CommitInfo, List[String], Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])]],Int,Boolean,Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(pathList: List[String],
  branch: String,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  commits: Seq[Seq[(gitbucket.core.util.JGitUtil.CommitInfo, List[String], Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])]],
  page: Int,
  hasNext: Boolean,
  hasWritePermission: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*8.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*9.2*/gitbucket/*9.11*/.core.html.main(s"${repository.owner}/${repository.name}", Some(repository))/*9.87*/ {_display_(Seq[Any](format.raw/*9.89*/("""
  """),_display_(/*10.4*/gitbucket/*10.13*/.core.html.menu("files", repository)/*10.49*/{_display_(Seq[Any](format.raw/*10.50*/("""
    """),format.raw/*11.5*/("""<div class="head">
      """),_display_(if(pathList.isEmpty)/*12.28*/{_display_(Seq[Any](format.raw/*12.29*/("""
        """),_display_(/*13.10*/gitbucket/*13.19*/.core.helper.html.branchcontrol(branch, repository, hasWritePermission)/*13.90*/{_display_(Seq[Any](format.raw/*13.91*/("""
          """),_display_(/*14.12*/repository/*14.22*/.branchList.map/*14.37*/ { x =>_display_(Seq[Any](format.raw/*14.44*/("""
            """),format.raw/*15.13*/("""<li><a href=""""),_display_(/*15.27*/helpers/*15.34*/.url(repository)),format.raw/*15.50*/("""/commits/"""),_display_(/*15.60*/helpers/*15.67*/.encodeRefName(x)),format.raw/*15.84*/("""">"""),_display_(/*15.87*/gitbucket/*15.96*/.core.helper.html.checkicon(x == branch)),format.raw/*15.136*/(""" """),_display_(/*15.138*/x),format.raw/*15.139*/("""</a></li>
          """)))}),format.raw/*16.12*/("""
        """)))}),format.raw/*17.10*/("""
      """)))} else {null} ),format.raw/*18.8*/("""
      """),_display_(if(pathList.nonEmpty)/*19.29*/{_display_(Seq[Any](format.raw/*19.30*/("""
        """),format.raw/*20.9*/("""<span class="muted">History for</span>
        <a class="strong" href=""""),_display_(/*21.34*/helpers/*21.41*/.url(repository)),format.raw/*21.57*/("""/tree/"""),_display_(/*21.64*/helpers/*21.71*/.encodeRefName(branch)),format.raw/*21.93*/("""">"""),_display_(/*21.96*/repository/*21.106*/.name),format.raw/*21.111*/("""</a> /
        """),_display_(/*22.10*/pathList/*22.18*/.zipWithIndex.map/*22.35*/ { case (section, i) =>_display_(Seq[Any](format.raw/*22.58*/("""
          """),_display_(if(i == pathList.length - 1)/*23.40*/{_display_(Seq[Any](format.raw/*23.41*/("""
            """),format.raw/*24.13*/("""<span class="strong">"""),_display_(/*24.35*/section),format.raw/*24.42*/("""</span>
          """)))}else/*25.18*/{_display_(Seq[Any](format.raw/*25.19*/("""
            """),format.raw/*26.13*/("""<a class="strong" href=""""),_display_(/*26.38*/helpers/*26.45*/.url(repository)),format.raw/*26.61*/("""/tree/"""),_display_(/*26.68*/helpers/*26.75*/.encodeRefName((branch :: pathList.take(i + 1)).mkString("/"))),format.raw/*26.137*/("""">"""),_display_(/*26.140*/section),format.raw/*26.147*/("""</a> /
          """)))}),format.raw/*27.12*/("""
        """)))}),format.raw/*28.10*/("""
      """)))} else {null} ),format.raw/*29.8*/("""
    """),format.raw/*30.5*/("""</div>

    <table class="table table-bordered table-hover">
    """),_display_(/*33.6*/commits/*33.13*/.map/*33.17*/ { day =>_display_(Seq[Any](format.raw/*33.26*/("""
      """),format.raw/*34.7*/("""<tr>
        <th rowspan=""""),_display_(/*35.23*/day/*35.26*/.size),format.raw/*35.31*/("""" width="100">"""),_display_(/*35.46*/helpers/*35.53*/.date(day.head._1.commitTime)),format.raw/*35.82*/("""</th>
        """),_display_(/*36.10*/day/*36.13*/.zipWithIndex.map/*36.30*/ { case ((commit, tags, status), i) =>_display_(Seq[Any](format.raw/*36.68*/("""
          """),_display_(if(i != 0)/*37.22*/{_display_(Seq[Any](format.raw/*37.23*/(""" """),format.raw/*37.24*/("""<tr> """)))} else {null} ),format.raw/*37.30*/("""
          """),format.raw/*38.11*/("""<td>
            <div class="pull-right text-right">
              """),_display_(if(commit.commitSign.isDefined)/*40.47*/{_display_(Seq[Any](format.raw/*40.48*/("""
                """),_display_(/*41.18*/commit/*41.24*/.verified.map/*41.37*/{ v =>_display_(Seq[Any](format.raw/*41.43*/("""
                  """),format.raw/*42.19*/("""<span class="gpg-verified" data-toggle="tooltip" title="Signed by """),_display_(/*42.86*/v/*42.87*/.signedUser),format.raw/*42.98*/(""" """),format.raw/*42.99*/("""("""),_display_(/*42.101*/v/*42.102*/.signedKeyId),format.raw/*42.114*/(""")">Verified</span>
                """)))}/*43.18*/.getOrElse/*43.28*/{_display_(Seq[Any](format.raw/*43.29*/("""
                  """),format.raw/*44.19*/("""<span class="gpg-unverified">Unverified</span>
                """)))}),format.raw/*45.18*/("""
              """)))} else {null} ),format.raw/*46.16*/("""
              """),_display_(if(tags.nonEmpty)/*47.33*/{_display_(Seq[Any](format.raw/*47.34*/("""
                """),format.raw/*48.17*/("""<span class="muted">
                  <i class="octicon octicon-tag"></i>
                  """),_display_(/*50.20*/tags/*50.24*/.map/*50.28*/ { tag =>_display_(Seq[Any](format.raw/*50.37*/("""
                    """),format.raw/*51.21*/("""<a href=""""),_display_(/*51.31*/helpers/*51.38*/.url(repository)),format.raw/*51.54*/("""/tree/"""),_display_(/*51.61*/tag),format.raw/*51.64*/("""" class="tag">"""),_display_(/*51.79*/tag),format.raw/*51.82*/("""</a>
                  """)))}),format.raw/*52.20*/("""
                """),format.raw/*53.17*/("""</span>
              """)))} else {null} ),format.raw/*54.16*/("""
              """),format.raw/*55.15*/("""<a href=""""),_display_(/*55.25*/helpers/*55.32*/.url(repository)),format.raw/*55.48*/("""/commit/"""),_display_(/*55.57*/commit/*55.63*/.id),format.raw/*55.66*/("""" class="monospace commit-message strong"><i class="octicon octicon-diff" style="color: black;"></i>"""),_display_(/*55.167*/commit/*55.173*/.id.substring(0, 7)),format.raw/*55.192*/("""</a><br>
              <a href=""""),_display_(/*56.25*/helpers/*56.32*/.url(repository)),format.raw/*56.48*/("""/tree/"""),_display_(/*56.55*/commit/*56.61*/.id),format.raw/*56.64*/("""" class="button-link">Browse files »</a>
            </div>
            <div>
              <div class="commit-avatar-image">"""),_display_(/*59.49*/helpers/*59.56*/.avatarLink(commit, 40)),format.raw/*59.79*/("""</div>
              <div>
                """),_display_(/*61.18*/helpers/*61.25*/.link(commit.summary, repository)),format.raw/*61.58*/("""
                """),_display_(if(commit.description.isDefined)/*62.50*/{_display_(Seq[Any](format.raw/*62.51*/("""
                  """),format.raw/*63.19*/("""<a href="javascript:void(0)" onclick="$('#description-"""),_display_(/*63.74*/commit/*63.80*/.id),format.raw/*63.83*/("""').toggle();" class="omit">...</a>
                """)))} else {null} ),format.raw/*64.18*/("""
                """),format.raw/*65.17*/("""<br>
                """),_display_(if(commit.description.isDefined)/*66.50*/{_display_(Seq[Any](format.raw/*66.51*/("""
                  """),format.raw/*67.19*/("""<pre id="description-"""),_display_(/*67.41*/commit/*67.47*/.id),format.raw/*67.50*/("""" style="display: none;" class="commit-description">"""),_display_(/*67.103*/helpers/*67.110*/.link(commit.description.get, repository)),format.raw/*67.151*/("""</pre>
                """)))} else {null} ),format.raw/*68.18*/("""
                  """),format.raw/*69.19*/("""<div>
                  """),_display_(if(commit.isDifferentFromAuthor)/*70.52*/ {_display_(Seq[Any](format.raw/*70.54*/("""
                    """),_display_(/*71.22*/helpers/*71.29*/.user(commit.authorName, commit.authorEmailAddress, "username")),format.raw/*71.92*/("""
                    """),format.raw/*72.21*/("""<span class="muted">authored """),_display_(/*72.51*/gitbucket/*72.60*/.core.helper.html.datetimeago(commit.authorTime)),format.raw/*72.108*/("""</span>
                    <span class="octicon octicon-arrow-right" style="margin-top : -2px;"></span>
                  """)))} else {null} ),format.raw/*74.20*/("""
                  """),_display_(/*75.20*/helpers/*75.27*/.user(commit.committerName, commit.committerEmailAddress, "username")),format.raw/*75.96*/("""
                  """),format.raw/*76.19*/("""<span class="muted">committed """),_display_(/*76.50*/gitbucket/*76.59*/.core.helper.html.datetimeago(commit.commitTime)),format.raw/*76.107*/("""</span>
                  """),_display_(/*77.20*/status/*77.26*/.map/*77.30*/ { case (summary, statuses) =>_display_(Seq[Any](format.raw/*77.60*/("""
                    """),_display_(/*78.22*/gitbucket/*78.31*/.core.helper.html.commitstatus(commit.id, summary, statuses)),format.raw/*78.91*/("""
                  """)))}),format.raw/*79.20*/("""
                """),format.raw/*80.17*/("""</div>
              </div>
            </div>
          </td>
          </tr>
        """)))}),format.raw/*85.10*/("""
    """)))}),format.raw/*86.6*/("""
    """),format.raw/*87.5*/("""</table>

    <nav style="text-align: center; margin-top: 20px">
      <ul class="pagination">
        """),_display_(if(page <= 1)/*91.23*/{_display_(Seq[Any](format.raw/*91.24*/("""
          """),format.raw/*92.11*/("""<li class="disabled"><span>Newer</span></li>
        """)))}else/*93.16*/{_display_(Seq[Any](format.raw/*93.17*/("""
          """),format.raw/*94.11*/("""<li><a href="?page="""),_display_(/*94.31*/{page - 1}),format.raw/*94.41*/("""">Newer</a></li>
        """)))}),format.raw/*95.10*/("""
        """),_display_(if(!hasNext)/*96.22*/{_display_(Seq[Any](format.raw/*96.23*/("""
          """),format.raw/*97.11*/("""<li class="disabled"><span>Older</span></li>
        """)))}else/*98.16*/{_display_(Seq[Any](format.raw/*98.17*/("""
          """),format.raw/*99.11*/("""<li><a href="?page="""),_display_(/*99.31*/{page + 1}),format.raw/*99.41*/("""">Older</a></li>
        """)))}),format.raw/*100.10*/("""
      """),format.raw/*101.7*/("""</ul>
    </nav>
    <script>
      $(function() """),format.raw/*104.20*/("""{"""),format.raw/*104.21*/("""
        """),format.raw/*105.9*/("""$('[data-toggle="tooltip"]').tooltip();
      """),format.raw/*106.7*/("""}"""),format.raw/*106.8*/(""");
    </script>
    <style type="text/css">
      a.tag """),format.raw/*109.13*/("""{"""),format.raw/*109.14*/("""
        """),format.raw/*110.9*/("""color: #888888;
        margin-right: 4px;
      """),format.raw/*112.7*/("""}"""),format.raw/*112.8*/("""
    """),format.raw/*113.5*/("""</style>
  """)))}),format.raw/*114.4*/("""
""")))}),format.raw/*115.2*/("""
"""))
      }
    }
  }

  def render(pathList:List[String],branch:String,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,commits:Seq[Seq[(gitbucket.core.util.JGitUtil.CommitInfo, List[String], Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])]],page:Int,hasNext:Boolean,hasWritePermission:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(pathList,branch,repository,commits,page,hasNext,hasWritePermission)(context)

  def f:((List[String],String,gitbucket.core.service.RepositoryService.RepositoryInfo,Seq[Seq[(gitbucket.core.util.JGitUtil.CommitInfo, List[String], Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])]],Int,Boolean,Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (pathList,branch,repository,commits,page,hasNext,hasWritePermission) => (context) => apply(pathList,branch,repository,commits,page,hasNext,hasWritePermission)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/repo/commits.scala.html
                  HASH: 11532697dafd6786ebfa83bac4f598b6e4239e6c
                  MATRIX: 856->1|1322->396|1385->432|1402->441|1486->517|1525->519|1555->523|1573->532|1618->568|1657->569|1689->574|1762->620|1801->621|1838->631|1856->640|1936->711|1975->712|2014->724|2033->734|2057->749|2102->756|2143->769|2184->783|2200->790|2237->806|2274->816|2290->823|2328->840|2358->843|2376->852|2438->892|2468->894|2491->895|2543->916|2584->926|2635->934|2691->963|2730->964|2766->973|2865->1045|2881->1052|2918->1068|2952->1075|2968->1082|3011->1104|3041->1107|3061->1117|3088->1122|3131->1138|3148->1146|3174->1163|3235->1186|3302->1226|3341->1227|3382->1240|3431->1262|3459->1269|3501->1294|3540->1295|3581->1308|3633->1333|3649->1340|3686->1356|3720->1363|3736->1370|3820->1432|3851->1435|3880->1442|3929->1460|3970->1470|4021->1478|4053->1483|4145->1549|4161->1556|4174->1560|4221->1569|4255->1576|4309->1603|4321->1606|4347->1611|4389->1626|4405->1633|4455->1662|4497->1677|4509->1680|4535->1697|4611->1735|4660->1757|4699->1758|4728->1759|4778->1765|4817->1776|4943->1875|4982->1876|5027->1894|5042->1900|5064->1913|5108->1919|5155->1938|5249->2005|5259->2006|5291->2017|5320->2018|5350->2020|5361->2021|5395->2033|5450->2069|5469->2079|5508->2080|5555->2099|5650->2163|5710->2179|5770->2212|5809->2213|5854->2230|5975->2324|5988->2328|6001->2332|6048->2341|6097->2362|6134->2372|6150->2379|6187->2395|6221->2402|6245->2405|6287->2420|6311->2423|6366->2447|6411->2464|6478->2487|6521->2502|6558->2512|6574->2519|6611->2535|6647->2544|6662->2550|6686->2553|6815->2654|6831->2660|6872->2679|6932->2712|6948->2719|6985->2735|7019->2742|7034->2748|7058->2751|7211->2877|7227->2884|7271->2907|7342->2951|7358->2958|7412->2991|7489->3041|7528->3042|7575->3061|7657->3116|7672->3122|7696->3125|7792->3177|7837->3194|7918->3248|7957->3249|8004->3268|8053->3290|8068->3296|8092->3299|8173->3352|8190->3359|8253->3400|8321->3424|8368->3443|8452->3500|8492->3502|8541->3524|8557->3531|8641->3594|8690->3615|8747->3645|8765->3654|8835->3702|9003->3826|9050->3846|9066->3853|9156->3922|9203->3941|9261->3972|9279->3981|9349->4029|9403->4056|9418->4062|9431->4066|9499->4096|9548->4118|9566->4127|9647->4187|9698->4207|9743->4224|9862->4312|9898->4318|9930->4323|10074->4440|10113->4441|10152->4452|10229->4512|10268->4513|10307->4524|10354->4544|10385->4554|10442->4580|10491->4602|10530->4603|10569->4614|10646->4674|10685->4675|10724->4686|10771->4706|10802->4716|10860->4742|10895->4749|10973->4798|11003->4799|11040->4808|11114->4854|11143->4855|11229->4912|11259->4913|11296->4922|11373->4971|11402->4972|11435->4977|11478->4989|11511->4991
                  LINES: 14->1|23->8|26->9|26->9|26->9|26->9|27->10|27->10|27->10|27->10|28->11|29->12|29->12|30->13|30->13|30->13|30->13|31->14|31->14|31->14|31->14|32->15|32->15|32->15|32->15|32->15|32->15|32->15|32->15|32->15|32->15|32->15|32->15|33->16|34->17|35->18|36->19|36->19|37->20|38->21|38->21|38->21|38->21|38->21|38->21|38->21|38->21|38->21|39->22|39->22|39->22|39->22|40->23|40->23|41->24|41->24|41->24|42->25|42->25|43->26|43->26|43->26|43->26|43->26|43->26|43->26|43->26|43->26|44->27|45->28|46->29|47->30|50->33|50->33|50->33|50->33|51->34|52->35|52->35|52->35|52->35|52->35|52->35|53->36|53->36|53->36|53->36|54->37|54->37|54->37|54->37|55->38|57->40|57->40|58->41|58->41|58->41|58->41|59->42|59->42|59->42|59->42|59->42|59->42|59->42|59->42|60->43|60->43|60->43|61->44|62->45|63->46|64->47|64->47|65->48|67->50|67->50|67->50|67->50|68->51|68->51|68->51|68->51|68->51|68->51|68->51|68->51|69->52|70->53|71->54|72->55|72->55|72->55|72->55|72->55|72->55|72->55|72->55|72->55|72->55|73->56|73->56|73->56|73->56|73->56|73->56|76->59|76->59|76->59|78->61|78->61|78->61|79->62|79->62|80->63|80->63|80->63|80->63|81->64|82->65|83->66|83->66|84->67|84->67|84->67|84->67|84->67|84->67|84->67|85->68|86->69|87->70|87->70|88->71|88->71|88->71|89->72|89->72|89->72|89->72|91->74|92->75|92->75|92->75|93->76|93->76|93->76|93->76|94->77|94->77|94->77|94->77|95->78|95->78|95->78|96->79|97->80|102->85|103->86|104->87|108->91|108->91|109->92|110->93|110->93|111->94|111->94|111->94|112->95|113->96|113->96|114->97|115->98|115->98|116->99|116->99|116->99|117->100|118->101|121->104|121->104|122->105|123->106|123->106|126->109|126->109|127->110|129->112|129->112|130->113|131->114|132->115
                  -- GENERATED --
              */
          