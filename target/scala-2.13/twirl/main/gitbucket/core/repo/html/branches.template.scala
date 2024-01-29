
package gitbucket.core.repo.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object branches extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Seq[(
    gitbucket.core.util.JGitUtil.BranchInfo,
    Option[(gitbucket.core.model.PullRequest, gitbucket.core.model.Issue)],
    Boolean,
    Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])]
  )],Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(branchInfo: Seq[(
    gitbucket.core.util.JGitUtil.BranchInfo,
    Option[(gitbucket.core.model.PullRequest, gitbucket.core.model.Issue)],
    Boolean,
    Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])]
  )],
  hasWritePermission: Boolean,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*9.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*10.2*/gitbucket/*10.11*/.core.html.main(s"${repository.owner}/${repository.name}", Some(repository))/*10.87*/ {_display_(Seq[Any](format.raw/*10.89*/("""
  """),_display_(/*11.4*/gitbucket/*11.13*/.core.html.menu("branches", repository)/*11.52*/{_display_(Seq[Any](format.raw/*11.53*/("""
    """),format.raw/*12.5*/("""<table class="table table-hover branches">
      <thead>
        <tr>
          <th colspan="3">All branches</th>
        </tr>
      </thead>
      <tbody>
      """),_display_(/*19.8*/branchInfo/*19.18*/.map/*19.22*/ { case (branch, prs, isProtected, status) =>_display_(Seq[Any](format.raw/*19.67*/("""
        """),format.raw/*20.9*/("""<tr>
          <td class="branch-details">
            """),_display_(if(isProtected)/*22.29*/{_display_(Seq[Any](format.raw/*22.30*/(""" """),format.raw/*22.31*/("""<span class="octicon octicon-shield" title="This branch is protected"></span> """)))} else {null} ),format.raw/*22.110*/("""
            """),format.raw/*23.13*/("""<a href=""""),_display_(/*23.23*/helpers/*23.30*/.url(repository)),format.raw/*23.46*/("""/tree/"""),_display_(/*23.53*/helpers/*23.60*/.encodeRefName(branch.name)),format.raw/*23.87*/("""">"""),_display_(/*23.90*/branch/*23.96*/.name),format.raw/*23.101*/("""</a>
            <span class="branch-meta">
              <span>Updated """),_display_(/*25.30*/gitbucket/*25.39*/.core.helper.html.datetimeago(branch.commitTime, false)),format.raw/*25.94*/("""
                """),format.raw/*26.17*/("""by <span>"""),_display_(/*26.27*/helpers/*26.34*/.user(branch.committerName, branch.committerEmailAddress, "muted-link")),format.raw/*26.105*/("""</span>
              </span>
            </span>
            """),_display_(/*29.14*/status/*29.20*/.map/*29.24*/ { case (summary, statuses) =>_display_(Seq[Any](format.raw/*29.54*/("""
              """),_display_(/*30.16*/gitbucket/*30.25*/.core.helper.html.commitstatus(branch.commitId, summary, statuses)),format.raw/*30.91*/("""
            """)))}),format.raw/*31.14*/("""
          """),format.raw/*32.11*/("""</td>
          <td class="branch-a-b-count">
            """),_display_(if(repository.repository.defaultBranch == branch.name)/*34.68*/{_display_(Seq[Any](format.raw/*34.69*/("""
              """),format.raw/*35.15*/("""<span class="badge">Default</span>
            """)))}else/*36.20*/{_display_(Seq[Any](format.raw/*36.21*/("""
              """),_display_(/*37.16*/branch/*37.22*/.mergeInfo.map/*37.36*/{ info =>_display_(Seq[Any](format.raw/*37.45*/("""
                """),format.raw/*38.17*/("""<div data-toggle="tooltip" title=""""),_display_(/*38.52*/info/*38.56*/.ahead),format.raw/*38.62*/(""" """),format.raw/*38.63*/("""commits ahead, """),_display_(/*38.79*/info/*38.83*/.behind),format.raw/*38.90*/(""" """),format.raw/*38.91*/("""commits behind """),_display_(/*38.107*/repository/*38.117*/.repository.defaultBranch),format.raw/*38.142*/("""">
                  <div class="a-b-count-widget">
                    <div class="count-half"><div class="count-value">"""),_display_(/*40.71*/info/*40.75*/.ahead),format.raw/*40.81*/("""</div></div>
                    <div class="count-half"><div class="count-value">"""),_display_(/*41.71*/info/*41.75*/.behind),format.raw/*41.82*/("""</div></div>
                  </div>
                </div>
              """)))}),format.raw/*44.16*/("""
            """)))}),format.raw/*45.14*/("""
          """),format.raw/*46.11*/("""</td>
          <td class="text-right">
            <div class="branch-action">
              """),_display_(if(repository.repository.defaultBranch != branch.name || repository.repository.originUserName.isDefined)/*49.120*/{_display_(Seq[Any](format.raw/*49.121*/("""
                """),_display_(/*50.18*/branch/*50.24*/.mergeInfo.map/*50.38*/{ info =>_display_(Seq[Any](format.raw/*50.47*/("""
                  """),_display_(/*51.20*/prs/*51.23*/.map/*51.27*/{ case (pull, issue) =>_display_(Seq[Any](format.raw/*51.50*/("""
                    """),format.raw/*52.21*/("""<a href=""""),_display_(/*52.31*/helpers/*52.38*/.url(repository)),format.raw/*52.54*/("""/pull/"""),_display_(/*52.61*/issue/*52.66*/.issueId),format.raw/*52.74*/("""" title=""""),_display_(/*52.84*/issue/*52.89*/.title),format.raw/*52.95*/("""">#"""),_display_(/*52.99*/issue/*52.104*/.issueId),format.raw/*52.112*/("""</a>
                    """),_display_(if(issue.closed)/*53.38*/ {_display_(Seq[Any](format.raw/*53.40*/("""
                      """),_display_(if(info.isMerged)/*54.41*/{_display_(Seq[Any](format.raw/*54.42*/("""
                        """),format.raw/*55.25*/("""<a href=""""),_display_(/*55.35*/helpers/*55.42*/.url(repository)),format.raw/*55.58*/("""/pull/"""),_display_(/*55.65*/issue/*55.70*/.issueId),format.raw/*55.78*/("""" title=""""),_display_(/*55.88*/issue/*55.93*/.title),format.raw/*55.99*/("""" class="label label-info">Merged</a>
                      """)))}else/*56.30*/{_display_(Seq[Any](format.raw/*56.31*/("""
                        """),format.raw/*57.25*/("""<a href=""""),_display_(/*57.35*/helpers/*57.42*/.url(repository)),format.raw/*57.58*/("""/pull/"""),_display_(/*57.65*/issue/*57.70*/.issueId),format.raw/*57.78*/("""" title=""""),_display_(/*57.88*/issue/*57.93*/.title),format.raw/*57.99*/("""" class="label label-important">Closed</a>
                      """)))}),format.raw/*58.24*/("""
                    """)))}else/*59.28*/{_display_(Seq[Any](format.raw/*59.29*/("""
                      """),format.raw/*60.23*/("""<a href=""""),_display_(/*60.33*/helpers/*60.40*/.url(repository)),format.raw/*60.56*/("""/pull/"""),_display_(/*60.63*/issue/*60.68*/.issueId),format.raw/*60.76*/("""" title=""""),_display_(/*60.86*/issue/*60.91*/.title),format.raw/*60.97*/("""" class="label label-success">Open</a>
                    """)))}),format.raw/*61.22*/("""
                  """)))}/*62.20*/.getOrElse/*62.30*/{_display_(Seq[Any](format.raw/*62.31*/("""
                    """),format.raw/*63.21*/("""<a href=""""),_display_(/*63.31*/helpers/*63.38*/.url(repository)),format.raw/*63.54*/("""/compare/"""),_display_(/*63.64*/{repository.repository.parentUserName.map { parent =>
                      helpers.urlEncode(parent) + ":" + helpers.encodeRefName(repository.repository.defaultBranch)
                    }.getOrElse {
                      helpers.encodeRefName(repository.repository.defaultBranch)
                    }}),format.raw/*67.23*/("""..."""),_display_(/*67.27*/{helpers.encodeRefName(branch.name)}),format.raw/*67.63*/("""" class="btn btn-default btn-sm">"""),_display_(if(context.loginAccount.isDefined)/*67.131*/{_display_(Seq[Any](format.raw/*67.132*/("""Create pull request""")))}else/*67.158*/{_display_(Seq[Any](format.raw/*67.159*/("""Compare""")))}),format.raw/*67.167*/("""</a>
                  """)))}),format.raw/*68.20*/("""
                  """),_display_(if(hasWritePermission)/*69.42*/{_display_(Seq[Any](format.raw/*69.43*/("""
                    """),format.raw/*70.21*/("""<span style="margin-left: 8px;">
                    """),_display_(if(prs.exists(!_._2.closed))/*71.50*/{_display_(Seq[Any](format.raw/*71.51*/("""
                      """),format.raw/*72.23*/("""<a class="disabled" data-toggle="tooltip" title="You can’t delete this branch because it has an open pull request"><i class="octicon octicon-trashcan"></i></a>
                    """)))}else/*73.28*/{_display_(Seq[Any](format.raw/*73.29*/("""
                      """),_display_(if(isProtected || repository.repository.defaultBranch == branch.name)/*74.93*/ {_display_(Seq[Any](format.raw/*74.95*/("""
                        """),format.raw/*75.25*/("""<a class="disabled" data-toggle="tooltip" title="You can’t delete a protected branch."><i class="octicon octicon-trashcan"></i></a>
                      """)))}else/*76.30*/{_display_(Seq[Any](format.raw/*76.31*/("""
                        """),format.raw/*77.25*/("""<a href=""""),_display_(/*77.35*/helpers/*77.42*/.url(repository)),format.raw/*77.58*/("""/delete/"""),_display_(/*77.67*/helpers/*77.74*/.encodeRefName(branch.name)),format.raw/*77.101*/("""" class="delete-branch" data-name=""""),_display_(/*77.137*/branch/*77.143*/.name),format.raw/*77.148*/("""" """),_display_(if(info.isMerged)/*77.168*/ {_display_(Seq[Any](format.raw/*77.170*/("""
                          """),format.raw/*78.27*/("""data-toggle="tooltip" title="this branch is merged" """)))} else {null} ),format.raw/*78.80*/("""><i class="octicon octicon-trashcan """),_display_(if(info.isMerged)/*78.134*/ {_display_(Seq[Any](format.raw/*78.136*/("""warning""")))}else/*78.150*/{_display_(Seq[Any](format.raw/*78.151*/("""danger""")))}),format.raw/*78.158*/(""""></i></a>
                      """)))}),format.raw/*79.24*/("""
                    """)))}),format.raw/*80.22*/("""
                    """),format.raw/*81.21*/("""</span>
                  """)))} else {null} ),format.raw/*82.20*/("""
                """)))}),format.raw/*83.18*/("""
              """)))} else {null} ),format.raw/*84.16*/("""
            """),format.raw/*85.13*/("""</div>
          </td>
        </tr>
      """)))}),format.raw/*88.8*/("""
    """),format.raw/*89.5*/("""</table>
  """)))}),format.raw/*90.4*/("""
""")))}),format.raw/*91.2*/("""
"""),format.raw/*92.1*/("""<script>
$(function()"""),format.raw/*93.13*/("""{"""),format.raw/*93.14*/("""
  """),format.raw/*94.3*/("""$('.delete-branch').click(function(e)"""),format.raw/*94.40*/("""{"""),format.raw/*94.41*/("""
    """),format.raw/*95.5*/("""const branchName = $(e.target).closest('a').data('name');
    return confirm('Are you sure you want to remove the ' + branchName + ' branch?');
  """),format.raw/*97.3*/("""}"""),format.raw/*97.4*/(""");
  $('*[data-toggle=tooltip]').tooltip().css("white-space","nowrap");
"""),format.raw/*99.1*/("""}"""),format.raw/*99.2*/(""");
</script>
"""))
      }
    }
  }

  def render(branchInfo:Seq[(
    gitbucket.core.util.JGitUtil.BranchInfo,
    Option[(gitbucket.core.model.PullRequest, gitbucket.core.model.Issue)],
    Boolean,
    Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])]
  )],hasWritePermission:Boolean,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(branchInfo,hasWritePermission,repository)(context)

  def f:((Seq[(
    gitbucket.core.util.JGitUtil.BranchInfo,
    Option[(gitbucket.core.model.PullRequest, gitbucket.core.model.Issue)],
    Boolean,
    Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])]
  )],Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (branchInfo,hasWritePermission,repository) => (context) => apply(branchInfo,hasWritePermission,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/repo/branches.scala.html
                  HASH: 229992320dcf0230c20d032c60d645ed7501f601
                  MATRIX: 907->1|1381->404|1445->440|1463->449|1548->525|1588->527|1618->531|1636->540|1684->579|1723->580|1755->585|1945->749|1964->759|1977->763|2060->808|2096->817|2194->888|2233->889|2262->890|2386->969|2427->982|2464->992|2480->999|2517->1015|2551->1022|2567->1029|2615->1056|2645->1059|2660->1065|2687->1070|2787->1143|2805->1152|2881->1207|2926->1224|2963->1234|2979->1241|3072->1312|3162->1375|3177->1381|3190->1385|3258->1415|3301->1431|3319->1440|3406->1506|3451->1520|3490->1531|3630->1644|3669->1645|3712->1660|3783->1714|3822->1715|3865->1731|3880->1737|3903->1751|3950->1760|3995->1777|4057->1812|4070->1816|4097->1822|4126->1823|4169->1839|4182->1843|4210->1850|4239->1851|4283->1867|4303->1877|4350->1902|4499->2024|4512->2028|4539->2034|4649->2117|4662->2121|4690->2128|4797->2204|4842->2218|4881->2229|5108->2428|5148->2429|5193->2447|5208->2453|5231->2467|5278->2476|5325->2496|5337->2499|5350->2503|5411->2526|5460->2547|5497->2557|5513->2564|5550->2580|5584->2587|5598->2592|5627->2600|5664->2610|5678->2615|5705->2621|5736->2625|5751->2630|5781->2638|5850->2680|5890->2682|5958->2723|5997->2724|6050->2749|6087->2759|6103->2766|6140->2782|6174->2789|6188->2794|6217->2802|6254->2812|6268->2817|6295->2823|6379->2890|6418->2891|6471->2916|6508->2926|6524->2933|6561->2949|6595->2956|6609->2961|6638->2969|6675->2979|6689->2984|6716->2990|6813->3056|6858->3084|6897->3085|6948->3108|6985->3118|7001->3125|7038->3141|7072->3148|7086->3153|7115->3161|7152->3171|7166->3176|7193->3182|7284->3242|7323->3262|7342->3272|7381->3273|7430->3294|7467->3304|7483->3311|7520->3327|7557->3337|7884->3643|7915->3647|7972->3683|8068->3751|8108->3752|8152->3778|8192->3779|8232->3787|8287->3811|8356->3853|8395->3854|8444->3875|8553->3957|8592->3958|8643->3981|8847->4168|8886->4169|9006->4262|9046->4264|9099->4289|9277->4450|9316->4451|9369->4476|9406->4486|9422->4493|9459->4509|9495->4518|9511->4525|9560->4552|9624->4588|9640->4594|9667->4599|9715->4619|9756->4621|9811->4648|9908->4701|9990->4755|10031->4757|10063->4771|10103->4772|10142->4779|10207->4813|10260->4835|10309->4856|10380->4883|10429->4901|10489->4917|10530->4930|10604->4974|10636->4979|10678->4991|10710->4993|10738->4994|10787->5015|10816->5016|10846->5019|10911->5056|10940->5057|10972->5062|11145->5208|11173->5209|11272->5281|11300->5282
                  LINES: 19->1|29->9|32->10|32->10|32->10|32->10|33->11|33->11|33->11|33->11|34->12|41->19|41->19|41->19|41->19|42->20|44->22|44->22|44->22|44->22|45->23|45->23|45->23|45->23|45->23|45->23|45->23|45->23|45->23|45->23|47->25|47->25|47->25|48->26|48->26|48->26|48->26|51->29|51->29|51->29|51->29|52->30|52->30|52->30|53->31|54->32|56->34|56->34|57->35|58->36|58->36|59->37|59->37|59->37|59->37|60->38|60->38|60->38|60->38|60->38|60->38|60->38|60->38|60->38|60->38|60->38|60->38|62->40|62->40|62->40|63->41|63->41|63->41|66->44|67->45|68->46|71->49|71->49|72->50|72->50|72->50|72->50|73->51|73->51|73->51|73->51|74->52|74->52|74->52|74->52|74->52|74->52|74->52|74->52|74->52|74->52|74->52|74->52|74->52|75->53|75->53|76->54|76->54|77->55|77->55|77->55|77->55|77->55|77->55|77->55|77->55|77->55|77->55|78->56|78->56|79->57|79->57|79->57|79->57|79->57|79->57|79->57|79->57|79->57|79->57|80->58|81->59|81->59|82->60|82->60|82->60|82->60|82->60|82->60|82->60|82->60|82->60|82->60|83->61|84->62|84->62|84->62|85->63|85->63|85->63|85->63|85->63|89->67|89->67|89->67|89->67|89->67|89->67|89->67|89->67|90->68|91->69|91->69|92->70|93->71|93->71|94->72|95->73|95->73|96->74|96->74|97->75|98->76|98->76|99->77|99->77|99->77|99->77|99->77|99->77|99->77|99->77|99->77|99->77|99->77|99->77|100->78|100->78|100->78|100->78|100->78|100->78|100->78|101->79|102->80|103->81|104->82|105->83|106->84|107->85|110->88|111->89|112->90|113->91|114->92|115->93|115->93|116->94|116->94|116->94|117->95|119->97|119->97|121->99|121->99
                  -- GENERATED --
              */
          