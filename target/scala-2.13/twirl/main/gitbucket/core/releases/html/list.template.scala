
package gitbucket.core.releases.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object list extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[gitbucket.core.service.RepositoryService.RepositoryInfo,Seq[(gitbucket.core.util.JGitUtil.TagInfo, Option[(gitbucket.core.model.ReleaseTag, Seq[gitbucket.core.model.ReleaseAsset])])],Boolean,Int,Int,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
    releases: Seq[(gitbucket.core.util.JGitUtil.TagInfo, Option[(gitbucket.core.model.ReleaseTag, Seq[gitbucket.core.model.ReleaseAsset])])],
    hasWritePermission: Boolean,
    page: Int, totalReleases: Int)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*6.2*/import gitbucket.core.view.helpers


Seq[Any](format.raw/*5.1*/("""
"""),_display_(/*7.2*/gitbucket/*7.11*/.core.html.main("Releases" + s" - ${repository.owner}/${repository.name}", Some(repository))/*7.103*/{_display_(Seq[Any](format.raw/*7.104*/("""
  """),_display_(/*8.4*/gitbucket/*8.13*/.core.html.menu("releases", repository)/*8.52*/{_display_(Seq[Any](format.raw/*8.53*/("""
    """),format.raw/*9.5*/("""<table class="table table-bordered table-releases">
      <thead>
        <tr><th>"""),_display_(/*11.18*/releases/*11.26*/.length),format.raw/*11.33*/(""" """),format.raw/*11.34*/("""releases</th></tr>
      </thead>
      <tbody>
      """),_display_(/*14.8*/releases/*14.16*/.map/*14.20*/ { case (tag, release) =>_display_(Seq[Any](format.raw/*14.45*/("""
        """),format.raw/*15.9*/("""<tr>
          <td>
            <div class="col-md-2 text-right">
              <a href=""""),_display_(/*18.25*/helpers/*18.32*/.url(repository)),format.raw/*18.48*/("""/tree/"""),_display_(/*18.55*/helpers/*18.62*/.urlEncode(tag.name)),format.raw/*18.82*/("""" class="strong"><i class="octicon octicon-tag"></i>"""),_display_(/*18.135*/tag/*18.138*/.name),format.raw/*18.143*/("""</a><br>
              <a href=""""),_display_(/*19.25*/helpers/*19.32*/.url(repository)),format.raw/*19.48*/("""/commit/"""),_display_(/*19.57*/tag/*19.60*/.commitId),format.raw/*19.69*/("""" class="monospace muted"><i class="octicon octicon-git-commit"></i>"""),_display_(/*19.138*/tag/*19.141*/.commitId.substring(0, 7)),format.raw/*19.166*/("""</a><br>
              <span class="muted">"""),_display_(/*20.36*/gitbucket/*20.45*/.core.helper.html.datetimeago(tag.time)),format.raw/*20.84*/("""</span>
            </div>
            <div class="col-md-10" style="border-left: 1px solid #eee">
              <div class="release-note markdown-body">
                """),_display_(/*24.18*/release/*24.25*/.map/*24.29*/ { case (release, assets) =>_display_(Seq[Any](format.raw/*24.57*/("""
                  """),format.raw/*25.19*/("""<h3><a href=""""),_display_(/*25.33*/helpers/*25.40*/.url(repository)),format.raw/*25.56*/("""/releases/"""),_display_(/*25.67*/helpers/*25.74*/.urlEncode(release.tag)),format.raw/*25.97*/("""">"""),_display_(/*25.100*/release/*25.107*/.name),format.raw/*25.112*/("""</a></h3>
                  <p class="muted">
                    """),_display_(/*27.22*/helpers/*27.29*/.avatarLink(release.author, 20)),format.raw/*27.60*/(""" """),_display_(/*27.62*/helpers/*27.69*/.user(release.author, styleClass="username")),format.raw/*27.113*/(""" """),format.raw/*27.114*/("""released this """),_display_(/*27.129*/gitbucket/*27.138*/.core.helper.html.datetimeago(release.registeredDate)),format.raw/*27.191*/("""
                  """),format.raw/*28.19*/("""</p>
                  """),_display_(/*29.20*/helpers/*29.27*/.markdown(
                    markdown           = release.content getOrElse "No description provided.",
                    repository         = repository,
                    branch             = repository.repository.defaultBranch,
                    enableWikiLink     = false,
                    enableRefsLink     = true,
                    enableLineBreaks   = true,
                    enableTaskList     = true,
                    hasWritePermission = hasWritePermission
                  )),format.raw/*38.20*/("""
                """)))}/*39.18*/.getOrElse/*39.28*/ {_display_(Seq[Any](format.raw/*39.30*/("""
                  """),_display_(if(hasWritePermission)/*40.42*/{_display_(Seq[Any](format.raw/*40.43*/("""
                    """),format.raw/*41.21*/("""<div class="pull-right">
                      <a class="btn btn-success" href=""""),_display_(/*42.57*/helpers/*42.64*/.url(repository)),format.raw/*42.80*/("""/releases/"""),_display_(/*42.91*/{helpers.urlEncode(tag.name)}),format.raw/*42.120*/("""/create" id="edit">Create release</a>
                    </div>
                  """)))} else {null} ),format.raw/*44.20*/("""
                  """),format.raw/*45.19*/("""<div>"""),_display_(/*45.25*/tag/*45.28*/.message),format.raw/*45.36*/("""<br><br></div>
                """)))}),format.raw/*46.18*/("""
                """),format.raw/*47.17*/("""<ul style="list-style: none; padding-left: 8px;">
                  """),_display_(/*48.20*/release/*48.27*/.map/*48.31*/ { case (release, assets) =>_display_(Seq[Any](format.raw/*48.59*/("""
                    """),_display_(/*49.22*/assets/*49.28*/.map/*49.32*/ { asset =>_display_(Seq[Any](format.raw/*49.43*/("""
                      """),format.raw/*50.23*/("""<li>
                        <a href=""""),_display_(/*51.35*/helpers/*51.42*/.url(repository)),format.raw/*51.58*/("""/releases/"""),_display_(/*51.69*/helpers/*51.76*/.urlEncode(release.tag)),format.raw/*51.99*/("""/assets/"""),_display_(/*51.108*/helpers/*51.115*/.urlEncode(asset.fileName)),format.raw/*51.141*/(""""><i class="octicon octicon-file" data-filename=""""),_display_(/*51.191*/asset/*51.196*/.label),format.raw/*51.202*/(""""></i>"""),_display_(/*51.209*/asset/*51.214*/.label),format.raw/*51.220*/("""</a>
                        <span class="label label-default">"""),_display_(/*52.60*/helpers/*52.67*/.readableSize(Some(asset.size))),format.raw/*52.98*/("""</span>
                      </li>
                    """)))}),format.raw/*54.22*/("""
                  """)))}),format.raw/*55.20*/("""
                  """),format.raw/*56.19*/("""<li><a href=""""),_display_(/*56.33*/helpers/*56.40*/.url(repository)),format.raw/*56.56*/("""/archive/"""),_display_(/*56.66*/{helpers.encodeRefName(tag.name)}),format.raw/*56.99*/(""".zip"><i class="octicon octicon-file-zip"></i>Source code (zip)</a></li>
                  <li><a href=""""),_display_(/*57.33*/helpers/*57.40*/.url(repository)),format.raw/*57.56*/("""/archive/"""),_display_(/*57.66*/{helpers.encodeRefName(tag.name)}),format.raw/*57.99*/(""".tar.gz"><i class="octicon octicon-file-zip"></i>Source code (tar.gz)</a></li>
                </ul>
              </div>
            </div>
          </td>
        </tr>
      """)))}),format.raw/*63.8*/("""
      """),format.raw/*64.7*/("""</tbody>
    </table>
    <div class="pull-right">
    """),_display_(/*67.6*/gitbucket/*67.15*/.core.helper.html.paginator(page, totalReleases, gitbucket.core.service.ReleaseService.ReleaseLimit, 10)),format.raw/*67.119*/("""
    """),format.raw/*68.5*/("""</div>

  """)))}),format.raw/*70.4*/("""
""")))}),format.raw/*71.2*/("""
"""))
      }
    }
  }

  def render(repository:gitbucket.core.service.RepositoryService.RepositoryInfo,releases:Seq[(gitbucket.core.util.JGitUtil.TagInfo, Option[(gitbucket.core.model.ReleaseTag, Seq[gitbucket.core.model.ReleaseAsset])])],hasWritePermission:Boolean,page:Int,totalReleases:Int,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(repository,releases,hasWritePermission,page,totalReleases)(context)

  def f:((gitbucket.core.service.RepositoryService.RepositoryInfo,Seq[(gitbucket.core.util.JGitUtil.TagInfo, Option[(gitbucket.core.model.ReleaseTag, Seq[gitbucket.core.model.ReleaseAsset])])],Boolean,Int,Int) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (repository,releases,hasWritePermission,page,totalReleases) => (context) => apply(repository,releases,hasWritePermission,page,totalReleases)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/releases/list.scala.html
                  HASH: 9c115ac13645fe1ff52f75bb7a5adf645932c490
                  MATRIX: 809->1|1214->336|1277->334|1304->372|1321->381|1422->473|1461->474|1490->478|1507->487|1554->526|1592->527|1623->532|1733->615|1750->623|1778->630|1807->631|1888->686|1905->694|1918->698|1981->723|2017->732|2134->822|2150->829|2187->845|2221->852|2237->859|2278->879|2359->932|2372->935|2399->940|2459->973|2475->980|2512->996|2548->1005|2560->1008|2590->1017|2687->1086|2700->1089|2747->1114|2818->1158|2836->1167|2896->1206|3094->1377|3110->1384|3123->1388|3189->1416|3236->1435|3277->1449|3293->1456|3330->1472|3368->1483|3384->1490|3428->1513|3459->1516|3476->1523|3503->1528|3597->1595|3613->1602|3665->1633|3694->1635|3710->1642|3776->1686|3806->1687|3849->1702|3868->1711|3943->1764|3990->1783|4041->1807|4057->1814|4583->2319|4620->2337|4639->2347|4679->2349|4748->2391|4787->2392|4836->2413|4944->2494|4960->2501|4997->2517|5035->2528|5086->2557|5214->2641|5261->2660|5294->2666|5306->2669|5335->2677|5398->2709|5443->2726|5539->2795|5555->2802|5568->2806|5634->2834|5683->2856|5698->2862|5711->2866|5760->2877|5811->2900|5877->2939|5893->2946|5930->2962|5968->2973|5984->2980|6028->3003|6065->3012|6082->3019|6130->3045|6208->3095|6223->3100|6251->3106|6286->3113|6301->3118|6329->3124|6420->3188|6436->3195|6488->3226|6576->3283|6627->3303|6674->3322|6715->3336|6731->3343|6768->3359|6805->3369|6859->3402|6991->3507|7007->3514|7044->3530|7081->3540|7135->3573|7343->3751|7377->3758|7459->3814|7477->3823|7603->3927|7635->3932|7676->3943|7708->3945
                  LINES: 14->1|20->6|23->5|24->7|24->7|24->7|24->7|25->8|25->8|25->8|25->8|26->9|28->11|28->11|28->11|28->11|31->14|31->14|31->14|31->14|32->15|35->18|35->18|35->18|35->18|35->18|35->18|35->18|35->18|35->18|36->19|36->19|36->19|36->19|36->19|36->19|36->19|36->19|36->19|37->20|37->20|37->20|41->24|41->24|41->24|41->24|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|45->28|46->29|46->29|55->38|56->39|56->39|56->39|57->40|57->40|58->41|59->42|59->42|59->42|59->42|59->42|61->44|62->45|62->45|62->45|62->45|63->46|64->47|65->48|65->48|65->48|65->48|66->49|66->49|66->49|66->49|67->50|68->51|68->51|68->51|68->51|68->51|68->51|68->51|68->51|68->51|68->51|68->51|68->51|68->51|68->51|68->51|69->52|69->52|69->52|71->54|72->55|73->56|73->56|73->56|73->56|73->56|73->56|74->57|74->57|74->57|74->57|74->57|80->63|81->64|84->67|84->67|84->67|85->68|87->70|88->71
                  -- GENERATED --
              */
          