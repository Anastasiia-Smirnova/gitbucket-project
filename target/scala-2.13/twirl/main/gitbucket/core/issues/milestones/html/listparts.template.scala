
package gitbucket.core.issues.milestones.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object listparts extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template12[List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],Int,Int,Int,gitbucket.core.service.IssuesService.IssueSearchCondition,List[String],List[gitbucket.core.model.Milestone],List[gitbucket.core.model.Priority],List[gitbucket.core.model.Label],Option[gitbucket.core.service.RepositoryService.RepositoryInfo],Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(issues: List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],
  page: Int,
  openCount: Int,
  closedCount: Int,
  condition: gitbucket.core.service.IssuesService.IssueSearchCondition,
  collaborators: List[String] = Nil,
  milestones: List[gitbucket.core.model.Milestone] = Nil,
  priorities: List[gitbucket.core.model.Priority] = Nil,
  labels: List[gitbucket.core.model.Label] = Nil,
  repository: Option[gitbucket.core.service.RepositoryService.RepositoryInfo] = None,
  isManageable: Boolean = false)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*12.2*/import gitbucket.core.view.helpers
/*13.2*/import gitbucket.core.service.IssuesService.IssueInfo


Seq[Any](format.raw/*23.3*/("""
"""),format.raw/*24.1*/("""<table class="table table-bordered table-hover table-issues">
  <thead>
    <tr>
      <th style="background-color: #eee;">
        """),_display_(if(isManageable)/*28.26*/{_display_(Seq[Any](format.raw/*28.27*/("""
          """),format.raw/*29.11*/("""<input type="checkbox" aria-label="Select all issues"/>
          <span id="table-issues-batchedit">
            """),_display_(/*31.14*/gitbucket/*31.23*/.core.helper.html.dropdown("Mark as")/*31.60*/ {_display_(Seq[Any](format.raw/*31.62*/("""
              """),format.raw/*32.15*/("""<li><a href="javascript:void(0);" class="toggle-state" data-id="open">Open</a></li>
              <li><a href="javascript:void(0);" class="toggle-state" data-id="close">Close</a></li>
            """)))}),format.raw/*34.14*/("""
            """),_display_(/*35.14*/gitbucket/*35.23*/.core.helper.html.dropdown("Label", filter = ("label", "Find Label..."))/*35.95*/ {_display_(Seq[Any](format.raw/*35.97*/("""
              """),_display_(/*36.16*/labels/*36.22*/.map/*36.26*/ { label =>_display_(Seq[Any](format.raw/*36.37*/("""
                """),format.raw/*37.17*/("""<li>
                  <a href="javascript:void(0);" class="toggle-label" data-id=""""),_display_(/*38.80*/label/*38.85*/.labelId),format.raw/*38.93*/("""">
                    <i class="octicon"></i>
                    <span class="label" style="background-color: #"""),_display_(/*40.68*/label/*40.73*/.color),format.raw/*40.79*/(""";">&nbsp;</span>
                    """),_display_(/*41.22*/label/*41.27*/.labelName),format.raw/*41.37*/("""
                  """),format.raw/*42.19*/("""</a>
                </li>
              """)))}),format.raw/*44.16*/("""
            """)))}),format.raw/*45.14*/("""
            """),_display_(/*46.14*/gitbucket/*46.23*/.core.helper.html.dropdown("Assignee", filter = ("assignee", "Find Assignee..."))/*46.104*/ {_display_(Seq[Any](format.raw/*46.106*/("""
              """),format.raw/*47.15*/("""<li><a href="javascript:void(0);" class="toggle-assign" data-name=""><i class="octicon octicon-x"></i> Clear assignee</a></li>
              """),_display_(/*48.16*/collaborators/*48.29*/.map/*48.33*/ { collaborator =>_display_(Seq[Any](format.raw/*48.51*/("""
                """),format.raw/*49.17*/("""<li><a href="javascript:void(0);" class="toggle-assign" data-name=""""),_display_(/*49.85*/collaborator),format.raw/*49.97*/(""""><i class="octicon"></i>"""),_display_(/*49.123*/helpers/*49.130*/.avatar(collaborator, 20)),format.raw/*49.155*/(""" """),_display_(/*49.157*/collaborator),format.raw/*49.169*/("""</a></li>
              """)))}),format.raw/*50.16*/("""
            """)))}),format.raw/*51.14*/("""
          """),format.raw/*52.11*/("""</span>
        """)))} else {null} ),format.raw/*53.10*/("""
      """),format.raw/*54.7*/("""</th>
    </tr>
  </thead>
  <tbody>
    """),_display_(if(issues.isEmpty)/*58.24*/{_display_(Seq[Any](format.raw/*58.25*/("""
      """),format.raw/*59.7*/("""<tr>
        <td style="padding: 20px; background-color: #eee; text-align: center;">
          No issues and pull requests to show.
        </td>
      </tr>
    """)))} else {null} ),format.raw/*64.6*/("""
    """),_display_(/*65.6*/issues/*65.12*/.map/*65.16*/ { case (IssueInfo(issue, labels, milestone, priority, commentCount, commitId, assignedUserNames), status) =>_display_(Seq[Any](format.raw/*65.125*/("""
      """),format.raw/*66.7*/("""<tr>
        <td style="padding-top: 12px; padding-bottom: 12px;">
          """),_display_(if(isManageable)/*68.28*/{_display_(Seq[Any](format.raw/*68.29*/("""
            """),format.raw/*69.13*/("""<input type="checkbox" value=""""),_display_(/*69.44*/issue/*69.49*/.issueId),format.raw/*69.57*/("""" aria-labelledby="issue_"""),_display_(/*69.83*/(issue.issueId)),format.raw/*69.98*/("""_link"/>
          """)))} else {null} ),format.raw/*70.12*/("""
          """),format.raw/*73.13*/("""
          """),_display_(if(repository.isEmpty)/*74.34*/{_display_(Seq[Any](format.raw/*74.35*/("""
            """),format.raw/*75.13*/("""<a href=""""),_display_(/*75.23*/context/*75.30*/.path),format.raw/*75.35*/("""/"""),_display_(/*75.37*/issue/*75.42*/.userName),format.raw/*75.51*/("""/"""),_display_(/*75.53*/issue/*75.58*/.repositoryName),format.raw/*75.73*/("""">"""),_display_(/*75.76*/issue/*75.81*/.repositoryName),format.raw/*75.96*/("""</a>&nbsp;&#xFF65;
          """)))} else {null} ),format.raw/*76.12*/("""
          """),_display_(if(issue.isPullRequest)/*77.35*/{_display_(Seq[Any](format.raw/*77.36*/("""
            """),format.raw/*78.13*/("""<a id="issue_"""),_display_(/*78.27*/(issue.issueId)),format.raw/*78.42*/("""_link" href=""""),_display_(/*78.56*/context/*78.63*/.path),format.raw/*78.68*/("""/"""),_display_(/*78.70*/issue/*78.75*/.userName),format.raw/*78.84*/("""/"""),_display_(/*78.86*/issue/*78.91*/.repositoryName),format.raw/*78.106*/("""/pull/"""),_display_(/*78.113*/issue/*78.118*/.issueId),format.raw/*78.126*/("""" class="issue-title">
              <i class="menu-icon octicon octicon-git-pull-request"></i>"""),_display_(/*79.74*/issue/*79.79*/.title),format.raw/*79.85*/("""
            """),format.raw/*80.13*/("""</a>
          """)))}else/*81.18*/{_display_(Seq[Any](format.raw/*81.19*/("""
            """),format.raw/*82.13*/("""<a id="issue_"""),_display_(/*82.27*/(issue.issueId)),format.raw/*82.42*/("""_link" href=""""),_display_(/*82.56*/context/*82.63*/.path),format.raw/*82.68*/("""/"""),_display_(/*82.70*/issue/*82.75*/.userName),format.raw/*82.84*/("""/"""),_display_(/*82.86*/issue/*82.91*/.repositoryName),format.raw/*82.106*/("""/issues/"""),_display_(/*82.115*/issue/*82.120*/.issueId),format.raw/*82.128*/("""" class="issue-title">
              """),_display_(if(issue.closed)/*83.32*/{_display_(Seq[Any](format.raw/*83.33*/("""<i class="menu-icon octicon octicon-issue-closed"></i>""")))}else/*83.92*/{_display_(Seq[Any](format.raw/*83.93*/("""<i class="menu-icon octicon octicon-issue-opened"></i>""")))}),_display_(/*83.149*/issue/*83.154*/.title),format.raw/*83.160*/("""
            """),format.raw/*84.13*/("""</a>
          """)))}),format.raw/*85.12*/("""
          """),_display_(/*86.12*/status/*86.18*/.map/*86.22*/ { case (summary, statuses) =>_display_(Seq[Any](format.raw/*86.52*/("""
            """),_display_(/*87.14*/gitbucket/*87.23*/.core.helper.html.commitstatus(commitId.get, summary, statuses)),format.raw/*87.86*/("""
          """)))}),format.raw/*88.12*/("""
          """),_display_(/*89.12*/labels/*89.18*/.map/*89.22*/ { label =>_display_(Seq[Any](format.raw/*89.33*/("""
            """),format.raw/*90.13*/("""<span class="label-color small" style="background-color: #"""),_display_(/*90.72*/label/*90.77*/.color),format.raw/*90.83*/("""; color: #"""),_display_(/*90.94*/label/*90.99*/.fontColor),format.raw/*90.109*/("""; padding-left: 4px; padding-right: 4px">"""),_display_(/*90.151*/label/*90.156*/.labelName),format.raw/*90.166*/("""</span>
          """)))}),format.raw/*91.12*/("""
          """),format.raw/*92.11*/("""<span class="pull-right small">
            """),_display_(/*93.14*/assignedUserNames/*93.31*/.map/*93.35*/ { userName =>_display_(Seq[Any](format.raw/*93.49*/("""
              """),_display_(/*94.16*/helpers/*94.23*/.avatar(userName, 20, tooltip = true)),format.raw/*94.60*/("""
            """)))}),format.raw/*95.14*/("""
            """),_display_(if(commentCount > 0)/*96.34*/{_display_(Seq[Any](format.raw/*96.35*/("""
              """),format.raw/*97.15*/("""<a href=""""),_display_(/*97.25*/context/*97.32*/.path),format.raw/*97.37*/("""/"""),_display_(/*97.39*/issue/*97.44*/.userName),format.raw/*97.53*/("""/"""),_display_(/*97.55*/issue/*97.60*/.repositoryName),format.raw/*97.75*/("""/issues/"""),_display_(/*97.84*/issue/*97.89*/.issueId),format.raw/*97.97*/("""" class="issue-comment-count">
                <i class="octicon octicon-comment active"></i> """),_display_(/*98.65*/commentCount),format.raw/*98.77*/("""
              """),format.raw/*99.15*/("""</a>
            """)))}else/*100.20*/{_display_(Seq[Any](format.raw/*100.21*/("""
              """),format.raw/*101.15*/("""<a href=""""),_display_(/*101.25*/context/*101.32*/.path),format.raw/*101.37*/("""/"""),_display_(/*101.39*/issue/*101.44*/.userName),format.raw/*101.53*/("""/"""),_display_(/*101.55*/issue/*101.60*/.repositoryName),format.raw/*101.75*/("""/issues/"""),_display_(/*101.84*/issue/*101.89*/.issueId),format.raw/*101.97*/("""" class="issue-comment-count" style="color: silver;">
                <i class="octicon octicon-comment"></i> """),_display_(/*102.58*/commentCount),format.raw/*102.70*/("""
              """),format.raw/*103.15*/("""</a>
            """)))}),format.raw/*104.14*/("""
          """),format.raw/*105.11*/("""</span>
          <div class="small muted" style="margin-left: 12px; margin-top: 2px;">
            #"""),_display_(/*107.15*/issue/*107.20*/.issueId),format.raw/*107.28*/(""" """),format.raw/*107.29*/("""opened """),_display_(/*107.37*/gitbucket/*107.46*/.core.helper.html.datetimeago(issue.registeredDate)),format.raw/*107.97*/(""" """),format.raw/*107.98*/("""by """),_display_(/*107.102*/helpers/*107.109*/.user(issue.openedUserName, styleClass="username")),format.raw/*107.159*/("""
            """),_display_(/*108.14*/priority/*108.22*/.map(priority => priorities.filter(p => p.priorityName == priority).head).map/*108.99*/ { priority =>_display_(Seq[Any](format.raw/*108.113*/("""
            """),format.raw/*109.13*/("""<span style="margin: 20px;"><a href=""""),_display_(/*109.51*/condition/*109.60*/.copy(priority = Some(Some(priority.priorityName))).toURL),format.raw/*109.117*/("""" class="username""""),_display_(if(!priority.description.isEmpty)/*109.169*/ {_display_(Seq[Any](format.raw/*109.171*/(""" """),format.raw/*109.172*/("""title=""""),_display_(/*109.180*/priority/*109.188*/.description.get),format.raw/*109.204*/("""" """)))} else {null} ),format.raw/*109.207*/("""><i class="octicon octicon-flame"></i>
              <span class="issue-priority issue-priority-inline" style="background-color: #"""),_display_(/*110.93*/priority/*110.101*/.color),format.raw/*110.107*/("""; color: #"""),_display_(/*110.118*/priority/*110.126*/.fontColor),format.raw/*110.136*/(""";">"""),_display_(/*110.140*/priority/*110.148*/.priorityName),format.raw/*110.161*/("""</span></a></span>
            """)))}),format.raw/*111.14*/("""
            """),_display_(/*112.14*/milestone/*112.23*/.map/*112.27*/ { milestone =>_display_(Seq[Any](format.raw/*112.42*/("""
              """),format.raw/*113.15*/("""<span style="margin: 20px;"><a href=""""),_display_(/*113.53*/condition/*113.62*/.copy(milestone = Some(Some(milestone))).toURL),format.raw/*113.108*/("""" class="username"><i class="octicon octicon-milestone"></i> """),_display_(/*113.170*/milestone),format.raw/*113.179*/("""</a></span>
            """)))}),format.raw/*114.14*/("""
          """),format.raw/*115.11*/("""</div>
        </td>
      </tr>
    """)))}),format.raw/*118.6*/("""
  """),format.raw/*119.3*/("""</tbody>
</table>
<div class="pull-right">
  """),_display_(/*122.4*/gitbucket/*122.13*/.core.helper.html.paginator(page, (if(condition.state == "open") openCount else closedCount), gitbucket.core.service.IssuesService.IssueLimit, 10, condition.toURL)),format.raw/*122.176*/("""
"""),format.raw/*123.1*/("""</div>
"""))
      }
    }
  }

  def render(issues:List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],page:Int,openCount:Int,closedCount:Int,condition:gitbucket.core.service.IssuesService.IssueSearchCondition,collaborators:List[String],milestones:List[gitbucket.core.model.Milestone],priorities:List[gitbucket.core.model.Priority],labels:List[gitbucket.core.model.Label],repository:Option[gitbucket.core.service.RepositoryService.RepositoryInfo],isManageable:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(issues,page,openCount,closedCount,condition,collaborators,milestones,priorities,labels,repository,isManageable)(context)

  def f:((List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],Int,Int,Int,gitbucket.core.service.IssuesService.IssueSearchCondition,List[String],List[gitbucket.core.model.Milestone],List[gitbucket.core.model.Priority],List[gitbucket.core.model.Label],Option[gitbucket.core.service.RepositoryService.RepositoryInfo],Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (issues,page,openCount,closedCount,condition,collaborators,milestones,priorities,labels,repository,isManageable) => (context) => apply(issues,page,openCount,closedCount,condition,collaborators,milestones,priorities,labels,repository,isManageable)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/issues/milestones/listparts.scala.html
                  HASH: 0cb6400ffdf9f177f8e86a759c4c7786d55842fa
                  MATRIX: 1026->1|1746->649|1789->685|1872->1065|1900->1066|2076->1215|2115->1216|2154->1227|2295->1341|2313->1350|2359->1387|2399->1389|2442->1404|2670->1601|2711->1615|2729->1624|2810->1696|2850->1698|2893->1714|2908->1720|2921->1724|2970->1735|3015->1752|3126->1836|3140->1841|3169->1849|3310->1963|3324->1968|3351->1974|3416->2012|3430->2017|3461->2027|3508->2046|3581->2088|3626->2102|3667->2116|3685->2125|3776->2206|3817->2208|3860->2223|4029->2365|4051->2378|4064->2382|4120->2400|4165->2417|4260->2485|4293->2497|4347->2523|4364->2530|4411->2555|4441->2557|4475->2569|4531->2594|4576->2608|4615->2619|4676->2636|4710->2643|4797->2703|4836->2704|4870->2711|5076->2874|5108->2880|5123->2886|5136->2890|5284->2999|5318->3006|5439->3100|5478->3101|5519->3114|5577->3145|5591->3150|5620->3158|5673->3184|5709->3199|5773->3219|5812->3363|5873->3397|5912->3398|5953->3411|5990->3421|6006->3428|6032->3433|6061->3435|6075->3440|6105->3449|6134->3451|6148->3456|6184->3471|6214->3474|6228->3479|6264->3494|6338->3524|6400->3559|6439->3560|6480->3573|6521->3587|6557->3602|6598->3616|6614->3623|6640->3628|6669->3630|6683->3635|6713->3644|6742->3646|6756->3651|6793->3666|6828->3673|6843->3678|6873->3686|6996->3782|7010->3787|7037->3793|7078->3806|7117->3828|7156->3829|7197->3842|7238->3856|7274->3871|7315->3885|7331->3892|7357->3897|7386->3899|7400->3904|7430->3913|7459->3915|7473->3920|7510->3935|7547->3944|7562->3949|7592->3957|7673->4011|7712->4012|7790->4071|7829->4072|7916->4128|7931->4133|7959->4139|8000->4152|8047->4168|8086->4180|8101->4186|8114->4190|8182->4220|8223->4234|8241->4243|8325->4306|8368->4318|8407->4330|8422->4336|8435->4340|8484->4351|8525->4364|8611->4423|8625->4428|8652->4434|8690->4445|8704->4450|8736->4460|8806->4502|8821->4507|8853->4517|8903->4536|8942->4547|9014->4592|9040->4609|9053->4613|9105->4627|9148->4643|9164->4650|9222->4687|9267->4701|9328->4735|9367->4736|9410->4751|9447->4761|9463->4768|9489->4773|9518->4775|9532->4780|9562->4789|9591->4791|9605->4796|9641->4811|9677->4820|9691->4825|9720->4833|9842->4928|9875->4940|9918->4955|9960->4979|10000->4980|10044->4995|10082->5005|10099->5012|10126->5017|10156->5019|10171->5024|10202->5033|10232->5035|10247->5040|10284->5055|10321->5064|10336->5069|10366->5077|10505->5188|10539->5200|10583->5215|10633->5233|10673->5244|10803->5346|10818->5351|10848->5359|10878->5360|10914->5368|10933->5377|11006->5428|11036->5429|11069->5433|11087->5440|11160->5490|11202->5504|11220->5512|11307->5589|11361->5603|11403->5616|11469->5654|11488->5663|11568->5720|11649->5772|11691->5774|11722->5775|11759->5783|11778->5791|11817->5807|11866->5810|12025->5941|12044->5949|12073->5955|12113->5966|12132->5974|12165->5984|12198->5988|12217->5996|12253->6009|12317->6041|12359->6055|12378->6064|12392->6068|12446->6083|12490->6098|12556->6136|12575->6145|12644->6191|12735->6253|12767->6262|12824->6287|12864->6298|12933->6336|12964->6339|13037->6385|13056->6394|13242->6557|13271->6558
                  LINES: 14->1|27->12|28->13|31->23|32->24|36->28|36->28|37->29|39->31|39->31|39->31|39->31|40->32|42->34|43->35|43->35|43->35|43->35|44->36|44->36|44->36|44->36|45->37|46->38|46->38|46->38|48->40|48->40|48->40|49->41|49->41|49->41|50->42|52->44|53->45|54->46|54->46|54->46|54->46|55->47|56->48|56->48|56->48|56->48|57->49|57->49|57->49|57->49|57->49|57->49|57->49|57->49|58->50|59->51|60->52|61->53|62->54|66->58|66->58|67->59|72->64|73->65|73->65|73->65|73->65|74->66|76->68|76->68|77->69|77->69|77->69|77->69|77->69|77->69|78->70|79->73|80->74|80->74|81->75|81->75|81->75|81->75|81->75|81->75|81->75|81->75|81->75|81->75|81->75|81->75|81->75|82->76|83->77|83->77|84->78|84->78|84->78|84->78|84->78|84->78|84->78|84->78|84->78|84->78|84->78|84->78|84->78|84->78|84->78|85->79|85->79|85->79|86->80|87->81|87->81|88->82|88->82|88->82|88->82|88->82|88->82|88->82|88->82|88->82|88->82|88->82|88->82|88->82|88->82|88->82|89->83|89->83|89->83|89->83|89->83|89->83|89->83|90->84|91->85|92->86|92->86|92->86|92->86|93->87|93->87|93->87|94->88|95->89|95->89|95->89|95->89|96->90|96->90|96->90|96->90|96->90|96->90|96->90|96->90|96->90|96->90|97->91|98->92|99->93|99->93|99->93|99->93|100->94|100->94|100->94|101->95|102->96|102->96|103->97|103->97|103->97|103->97|103->97|103->97|103->97|103->97|103->97|103->97|103->97|103->97|103->97|104->98|104->98|105->99|106->100|106->100|107->101|107->101|107->101|107->101|107->101|107->101|107->101|107->101|107->101|107->101|107->101|107->101|107->101|108->102|108->102|109->103|110->104|111->105|113->107|113->107|113->107|113->107|113->107|113->107|113->107|113->107|113->107|113->107|113->107|114->108|114->108|114->108|114->108|115->109|115->109|115->109|115->109|115->109|115->109|115->109|115->109|115->109|115->109|115->109|116->110|116->110|116->110|116->110|116->110|116->110|116->110|116->110|116->110|117->111|118->112|118->112|118->112|118->112|119->113|119->113|119->113|119->113|119->113|119->113|120->114|121->115|124->118|125->119|128->122|128->122|128->122|129->123
                  -- GENERATED --
              */
          