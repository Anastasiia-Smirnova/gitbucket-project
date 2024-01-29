
package gitbucket.core.settings.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object branches extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[gitbucket.core.service.RepositoryService.RepositoryInfo,Seq[String],Option[Any],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  protectedBranchList: Seq[String],
  info: Option[Any])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*4.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*5.2*/gitbucket/*5.11*/.core.html.main("Branches", Some(repository))/*5.56*/{_display_(Seq[Any](format.raw/*5.57*/("""
  """),_display_(/*6.4*/gitbucket/*6.13*/.core.html.menu("settings", repository)/*6.52*/{_display_(Seq[Any](format.raw/*6.53*/("""
    """),_display_(/*7.6*/gitbucket/*7.15*/.core.settings.html.menu("branches", repository)/*7.63*/{_display_(Seq[Any](format.raw/*7.64*/("""
      """),_display_(if(repository.branchList.isEmpty)/*8.41*/{_display_(Seq[Any](format.raw/*8.42*/("""
        """),format.raw/*9.9*/("""<div class="well">
          <center>
            <p><i class="octicon octicon-git-branch" style="font-size:300%"></i></p>
            <p>You don’t have any branches</p>
            <p>Before you can edit branch settings, you need to add a branch.</p>
          </center>
        </div>
      """)))}else/*16.14*/{_display_(Seq[Any](format.raw/*16.15*/("""
        """),_display_(/*17.10*/gitbucket/*17.19*/.core.helper.html.information(info)),format.raw/*17.54*/("""
        """),format.raw/*18.9*/("""<div class="panel panel-default">
          <div class="panel-heading strong">Default branch</div>
          <div class="panel-body">
            <p>The default branch is considered the “base” branch in your repository, against which all pull requests and code commits are automatically made (unless you specify a different branch).</p>
            <form id="form" method="post" action=""""),_display_(/*22.52*/helpers/*22.59*/.url(repository)),format.raw/*22.75*/("""/settings/update_default_branch" validate="true" class="form-inline">
              <span class="error" id="error-defaultBranch"></span>
              <select name="defaultBranch" id="defaultBranch" class="form-control" aria-label="Default branch">
                """),_display_(/*25.18*/repository/*25.28*/.branchList.map/*25.43*/ { branch =>_display_(Seq[Any](format.raw/*25.55*/("""
                  """),format.raw/*26.19*/("""<option """),_display_(if(branch==repository.repository.defaultBranch)/*26.75*/{_display_(Seq[Any](format.raw/*26.76*/(""" """),format.raw/*26.77*/("""selected""")))} else {null} ),format.raw/*26.86*/(""">"""),_display_(/*26.88*/branch),format.raw/*26.94*/("""</option>
                """)))}),format.raw/*27.18*/("""
              """),format.raw/*28.15*/("""</select>
              <input type="submit" class="btn btn-default" value="Update" />
            </form>
          </div>
        </div>

        <div class="panel panel-default">
          <div class="panel-heading strong">Protected branches</div>
          <div class="panel-body">
            <p>Protect branches to disable force pushing, prevent branches from being deleted, and optionally, require status checks before merging.
              <form class="form-inline">
                <select name="protectBranch" id="protectBranch" onchange="location=$(this).val()" class="form-control" aria-label="Protect branch">
                  <option>Choose a branch...</option>
                  """),_display_(/*41.20*/repository/*41.30*/.branchList.map/*41.45*/ { branch =>_display_(Seq[Any](format.raw/*41.57*/("""
                    """),format.raw/*42.21*/("""<option value=""""),_display_(/*42.37*/helpers/*42.44*/.url(repository)),format.raw/*42.60*/("""/settings/branches/"""),_display_(/*42.80*/helpers/*42.87*/.urlEncode(branch)),format.raw/*42.105*/("""">"""),_display_(/*42.108*/branch),format.raw/*42.114*/("""</option>
                  """)))}),format.raw/*43.20*/("""
                """),format.raw/*44.17*/("""</select>
                <span class="error" id="error-protectBranch"></span>
              </form>
            </p>

            <table class="table table-hover branches">
              """),_display_(/*50.16*/protectedBranchList/*50.35*/.map/*50.39*/ { branch =>_display_(Seq[Any](format.raw/*50.51*/("""
                """),format.raw/*51.17*/("""<tr>
                  <td>
                    <span class="branch-name">"""),_display_(/*53.48*/branch),format.raw/*53.54*/("""</span>
                    <a href=""""),_display_(/*54.31*/helpers/*54.38*/.url(repository)),format.raw/*54.54*/("""/settings/branches/"""),_display_(/*54.74*/helpers/*54.81*/.urlEncode(branch)),format.raw/*54.99*/("""" class="btn btn-sm btn-default pull-right">Edit</a>
                  </td>
                </tr>
              """)))}),format.raw/*57.16*/("""
            """),format.raw/*58.13*/("""</table>
          </div>

        </div>
      """)))}),format.raw/*62.8*/("""
    """)))}),format.raw/*63.6*/("""
  """)))}),format.raw/*64.4*/("""
""")))}),format.raw/*65.2*/("""
"""))
      }
    }
  }

  def render(repository:gitbucket.core.service.RepositoryService.RepositoryInfo,protectedBranchList:Seq[String],info:Option[Any],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(repository,protectedBranchList,info)(context)

  def f:((gitbucket.core.service.RepositoryService.RepositoryInfo,Seq[String],Option[Any]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (repository,protectedBranchList,info) => (context) => apply(repository,protectedBranchList,info)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/settings/branches.scala.html
                  HASH: 8cb2cd0afe1a4017f00bf2a5d102fe49a30422bd
                  MATRIX: 694->1|946->182|1009->218|1026->227|1079->272|1117->273|1146->277|1163->286|1210->325|1248->326|1279->332|1296->341|1352->389|1390->390|1457->431|1495->432|1530->441|1847->741|1886->742|1923->752|1941->761|1997->796|2033->805|2448->1193|2464->1200|2501->1216|2794->1482|2813->1492|2837->1507|2887->1519|2934->1538|3017->1594|3056->1595|3085->1596|3138->1605|3167->1607|3194->1613|3252->1640|3295->1655|4019->2352|4038->2362|4062->2377|4112->2389|4161->2410|4204->2426|4220->2433|4257->2449|4304->2469|4320->2476|4360->2494|4391->2497|4419->2503|4479->2532|4524->2549|4740->2738|4768->2757|4781->2761|4831->2773|4876->2790|4978->2865|5005->2871|5070->2909|5086->2916|5123->2932|5170->2952|5186->2959|5225->2977|5370->3091|5411->3104|5490->3153|5526->3159|5560->3163|5592->3165
                  LINES: 14->1|19->4|22->5|22->5|22->5|22->5|23->6|23->6|23->6|23->6|24->7|24->7|24->7|24->7|25->8|25->8|26->9|33->16|33->16|34->17|34->17|34->17|35->18|39->22|39->22|39->22|42->25|42->25|42->25|42->25|43->26|43->26|43->26|43->26|43->26|43->26|43->26|44->27|45->28|58->41|58->41|58->41|58->41|59->42|59->42|59->42|59->42|59->42|59->42|59->42|59->42|59->42|60->43|61->44|67->50|67->50|67->50|67->50|68->51|70->53|70->53|71->54|71->54|71->54|71->54|71->54|71->54|74->57|75->58|79->62|80->63|81->64|82->65
                  -- GENERATED --
              */
          