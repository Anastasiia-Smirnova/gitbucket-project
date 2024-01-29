
package gitbucket.core.releases.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object release extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[gitbucket.core.model.ReleaseTag,Seq[gitbucket.core.model.ReleaseAsset],Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(release: gitbucket.core.model.ReleaseTag,
  assets: Seq[gitbucket.core.model.ReleaseAsset],
  hasWritePermission: Boolean,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*5.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*6.2*/gitbucket/*6.11*/.core.html.main(s"Release ${release.name} - ${repository.owner}/${repository.name}", Some(repository))/*6.113*/{_display_(Seq[Any](format.raw/*6.114*/("""
  """),_display_(/*7.4*/gitbucket/*7.13*/.core.html.menu("releases", repository)/*7.52*/{_display_(Seq[Any](format.raw/*7.53*/("""
    """),format.raw/*8.5*/("""<div class="row">
      <div class="col-md-2 text-right">
        """),_display_(/*10.10*/defining(repository.tags.find(_.name == release.tag))/*10.63*/{ tag =>_display_(Seq[Any](format.raw/*10.71*/("""
          """),_display_(/*11.12*/tag/*11.15*/.map/*11.19*/ { tag =>_display_(Seq[Any](format.raw/*11.28*/("""
            """),format.raw/*12.13*/("""<a href=""""),_display_(/*12.23*/helpers/*12.30*/.url(repository)),format.raw/*12.46*/("""/tree/"""),_display_(/*12.53*/helpers/*12.60*/.urlEncode(tag.name)),format.raw/*12.80*/("""" class="strong"><i class="octicon octicon-tag"></i>"""),_display_(/*12.133*/tag/*12.136*/.name),format.raw/*12.141*/("""</a><br>
            <a href=""""),_display_(/*13.23*/helpers/*13.30*/.url(repository)),format.raw/*13.46*/("""/commit/"""),_display_(/*13.55*/tag/*13.58*/.commitId),format.raw/*13.67*/("""" class="monospace muted"><i class="octicon octicon-git-commit"></i>"""),_display_(/*13.136*/tag/*13.139*/.commitId.substring(0, 7)),format.raw/*13.164*/("""</a><br>
            <span class="muted">"""),_display_(/*14.34*/gitbucket/*14.43*/.core.helper.html.datetimeago(tag.time)),format.raw/*14.82*/("""</span>
          """)))}),format.raw/*15.12*/("""
        """)))}),format.raw/*16.10*/("""
      """),format.raw/*17.7*/("""</div>
      <div class="col-md-10" style="border-left: 1px solid #eee">
        <div class="markdown-body">
          <h3>
            """),_display_(/*21.14*/release/*21.21*/.name),format.raw/*21.26*/("""
            """),_display_(if(hasWritePermission)/*22.36*/{_display_(Seq[Any](format.raw/*22.37*/("""
              """),format.raw/*23.15*/("""<div class="pull-right">
                <form method="POST" action=""""),_display_(/*24.46*/helpers/*24.53*/.url(repository)),format.raw/*24.69*/("""/releases/"""),_display_(/*24.80*/release/*24.87*/.tag),format.raw/*24.91*/("""/delete" id="delete-form">
                  <a class="btn btn-default" href=""""),_display_(/*25.53*/helpers/*25.60*/.url(repository)),format.raw/*25.76*/("""/releases/"""),_display_(/*25.87*/release/*25.94*/.tag),format.raw/*25.98*/("""/edit" id="edit">Edit</a>
                  <input type="submit" class="btn btn-danger" value="Delete">
                </form>
              </div>
            """)))} else {null} ),format.raw/*29.14*/("""
          """),format.raw/*30.11*/("""</h3>
          <p class="muted">
           """),_display_(/*32.13*/helpers/*32.20*/.avatarLink(release.author, 20)),format.raw/*32.51*/(""" """),_display_(/*32.53*/helpers/*32.60*/.user(release.author, styleClass="username")),format.raw/*32.104*/(""" """),format.raw/*32.105*/("""released this """),_display_(/*32.120*/gitbucket/*32.129*/.core.helper.html.datetimeago(release.registeredDate)),format.raw/*32.182*/("""
          """),format.raw/*33.11*/("""</p>
          """),_display_(/*34.12*/helpers/*34.19*/.markdown(
            markdown           = release.content getOrElse "No description provided.",
            repository         = repository,
            branch             = repository.repository.defaultBranch,
            enableWikiLink     = false,
            enableRefsLink     = true,
            enableLineBreaks   = true,
            enableTaskList     = true,
            hasWritePermission = hasWritePermission
          )),format.raw/*43.12*/("""
          """),format.raw/*44.11*/("""<ul style="list-style: none; padding-left: 8px;" id="attachedFiles">
            """),_display_(/*45.14*/assets/*45.20*/.map/*45.24*/{ asset =>_display_(Seq[Any](format.raw/*45.34*/("""
              """),format.raw/*46.15*/("""<li>
                <a href=""""),_display_(/*47.27*/helpers/*47.34*/.url(repository)),format.raw/*47.50*/("""/releases/"""),_display_(/*47.61*/release/*47.68*/.tag),format.raw/*47.72*/("""/assets/"""),_display_(/*47.81*/asset/*47.86*/.fileName),format.raw/*47.95*/(""""><i class="octicon octicon-file" data-filename=""""),_display_(/*47.145*/helpers/*47.152*/.urlEncode(asset.label)),format.raw/*47.175*/(""""></i>"""),_display_(/*47.182*/asset/*47.187*/.label),format.raw/*47.193*/("""</a>
                <span class="label label-default">"""),_display_(/*48.52*/helpers/*48.59*/.readableSize(Some(asset.size))),format.raw/*48.90*/("""</span>
              </li>
            """)))}),format.raw/*50.14*/("""
            """),format.raw/*51.13*/("""<li><a href=""""),_display_(/*51.27*/helpers/*51.34*/.url(repository)),format.raw/*51.50*/("""/archive/"""),_display_(/*51.60*/{helpers.encodeRefName(release.tag)}),format.raw/*51.96*/(""".zip"><i class="octicon octicon-file-zip"></i>Source code (zip)</a></li>
            <li><a href=""""),_display_(/*52.27*/helpers/*52.34*/.url(repository)),format.raw/*52.50*/("""/archive/"""),_display_(/*52.60*/{helpers.encodeRefName(release.tag)}),format.raw/*52.96*/(""".tar.gz"><i class="octicon octicon-file-zip"></i>Source code (tar.gz)</a></li>
          </ul>
        </div>
      </div>
    </div>
  """)))}),format.raw/*57.4*/("""
""")))}),format.raw/*58.2*/("""
"""),format.raw/*59.1*/("""<script>
$(function()"""),format.raw/*60.13*/("""{"""),format.raw/*60.14*/("""
  """),format.raw/*61.3*/("""$('#delete-form').submit(function()"""),format.raw/*61.38*/("""{"""),format.raw/*61.39*/("""
    """),format.raw/*62.5*/("""return confirm('Are you sure you want to delete this release?');
  """),format.raw/*63.3*/("""}"""),format.raw/*63.4*/(""");
"""),format.raw/*64.1*/("""}"""),format.raw/*64.2*/(""");
</script>
"""))
      }
    }
  }

  def render(release:gitbucket.core.model.ReleaseTag,assets:Seq[gitbucket.core.model.ReleaseAsset],hasWritePermission:Boolean,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(release,assets,hasWritePermission,repository)(context)

  def f:((gitbucket.core.model.ReleaseTag,Seq[gitbucket.core.model.ReleaseAsset],Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (release,assets,hasWritePermission,repository) => (context) => apply(release,assets,hasWritePermission,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/releases/release.scala.html
                  HASH: 834bce173beeb250051745c64accabbe345c3e45
                  MATRIX: 748->1|1068->250|1131->286|1148->295|1259->397|1298->398|1327->402|1344->411|1391->450|1429->451|1460->456|1554->523|1616->576|1662->584|1701->596|1713->599|1726->603|1773->612|1814->625|1851->635|1867->642|1904->658|1938->665|1954->672|1995->692|2076->745|2089->748|2116->753|2174->784|2190->791|2227->807|2263->816|2275->819|2305->828|2402->897|2415->900|2462->925|2531->967|2549->976|2609->1015|2659->1034|2700->1044|2734->1051|2898->1188|2914->1195|2940->1200|3003->1236|3042->1237|3085->1252|3182->1322|3198->1329|3235->1345|3273->1356|3289->1363|3314->1367|3420->1446|3436->1453|3473->1469|3511->1480|3527->1487|3552->1491|3758->1653|3797->1664|3870->1710|3886->1717|3938->1748|3967->1750|3983->1757|4049->1801|4079->1802|4122->1817|4141->1826|4216->1879|4255->1890|4298->1906|4314->1913|4768->2346|4807->2357|4916->2439|4931->2445|4944->2449|4992->2459|5035->2474|5093->2505|5109->2512|5146->2528|5184->2539|5200->2546|5225->2550|5261->2559|5275->2564|5305->2573|5383->2623|5400->2630|5445->2653|5480->2660|5495->2665|5523->2671|5606->2727|5622->2734|5674->2765|5746->2806|5787->2819|5828->2833|5844->2840|5881->2856|5918->2866|5975->2902|6101->3001|6117->3008|6154->3024|6191->3034|6248->3070|6415->3207|6447->3209|6475->3210|6524->3231|6553->3232|6583->3235|6646->3270|6675->3271|6707->3276|6801->3343|6829->3344|6859->3347|6887->3348
                  LINES: 14->1|20->5|23->6|23->6|23->6|23->6|24->7|24->7|24->7|24->7|25->8|27->10|27->10|27->10|28->11|28->11|28->11|28->11|29->12|29->12|29->12|29->12|29->12|29->12|29->12|29->12|29->12|29->12|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|31->14|31->14|31->14|32->15|33->16|34->17|38->21|38->21|38->21|39->22|39->22|40->23|41->24|41->24|41->24|41->24|41->24|41->24|42->25|42->25|42->25|42->25|42->25|42->25|46->29|47->30|49->32|49->32|49->32|49->32|49->32|49->32|49->32|49->32|49->32|49->32|50->33|51->34|51->34|60->43|61->44|62->45|62->45|62->45|62->45|63->46|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|65->48|65->48|65->48|67->50|68->51|68->51|68->51|68->51|68->51|68->51|69->52|69->52|69->52|69->52|69->52|74->57|75->58|76->59|77->60|77->60|78->61|78->61|78->61|79->62|80->63|80->63|81->64|81->64
                  -- GENERATED --
              */
          