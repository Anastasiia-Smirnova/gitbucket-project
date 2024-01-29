
package gitbucket.core.issues.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object listparts extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template13[String,List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],Int,Int,Int,gitbucket.core.service.IssuesService.IssueSearchCondition,List[String],List[gitbucket.core.model.Milestone],List[gitbucket.core.model.Priority],List[gitbucket.core.model.Label],Option[gitbucket.core.service.RepositoryService.RepositoryInfo],Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(target: String,
  issues: List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],
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
/*13.2*/import gitbucket.core.view.helpers
/*14.2*/import gitbucket.core.service.IssuesService.IssueInfo


Seq[Any](format.raw/*24.3*/("""
"""),format.raw/*25.1*/("""<table class="table table-bordered table-hover table-issues">
  <thead>
    <tr>
      <th style="background-color: #eee;">
        <input type="checkbox" aria-label="Select all issues"/>
        <span id="table-issues-control">
          """),_display_(/*31.12*/gitbucket/*31.21*/.core.helper.html.dropdown("Author", filter = ("author", "Find Author..."))/*31.96*/ {_display_(Seq[Any](format.raw/*31.98*/("""
            """),_display_(/*32.14*/collaborators/*32.27*/.map/*32.31*/ { collaborator =>_display_(Seq[Any](format.raw/*32.49*/("""
              """),format.raw/*33.15*/("""<li>
                <a href=""""),_display_(/*34.27*/condition/*34.36*/.copy(author = (if(condition.author == Some(collaborator)) None else Some(collaborator))).toURL),format.raw/*34.131*/("""">
                  """),_display_(/*35.20*/gitbucket/*35.29*/.core.helper.html.checkicon(condition.author == Some(collaborator))),format.raw/*35.96*/("""
                  """),_display_(/*36.20*/helpers/*36.27*/.avatar(collaborator, 20)),format.raw/*36.52*/(""" """),_display_(/*36.54*/collaborator),format.raw/*36.66*/("""
                """),format.raw/*37.17*/("""</a>
              </li>
            """)))}),format.raw/*39.14*/("""
          """)))}),format.raw/*40.12*/("""
          """),_display_(/*41.12*/gitbucket/*41.21*/.core.helper.html.dropdown("Label", filter = ("label", "Find Label..."))/*41.93*/ {_display_(Seq[Any](format.raw/*41.95*/("""
            """),_display_(/*42.14*/labels/*42.20*/.map/*42.24*/ { label =>_display_(Seq[Any](format.raw/*42.35*/("""
              """),format.raw/*43.15*/("""<li>
                <a href=""""),_display_(/*44.27*/condition/*44.36*/.copy(labels = (if(condition.labels.contains(label.labelName)) condition.labels - label.labelName else condition.labels + label.labelName)).toURL),format.raw/*44.181*/("""">
                  """),_display_(/*45.20*/gitbucket/*45.29*/.core.helper.html.checkicon(condition.labels.contains(label.labelName))),format.raw/*45.100*/("""
                  """),format.raw/*46.19*/("""<span style="background-color: #"""),_display_(/*46.52*/label/*46.57*/.color),format.raw/*46.63*/(""";" class="label-color">&nbsp;&nbsp;</span>
                  """),_display_(/*47.20*/label/*47.25*/.labelName),format.raw/*47.35*/("""
                """),format.raw/*48.17*/("""</a>
              </li>
            """)))}),format.raw/*50.14*/("""
          """)))}),format.raw/*51.12*/("""
          """),_display_(/*52.12*/gitbucket/*52.21*/.core.helper.html.dropdown("Priority", filter = ("priority", "Find Priority..."))/*52.102*/ {_display_(Seq[Any](format.raw/*52.104*/("""
            """),format.raw/*53.13*/("""<li>
              <a href=""""),_display_(/*54.25*/condition/*54.34*/.copy(priority = (if(condition.priority == Some(None)) None else Some(None))).toURL),format.raw/*54.117*/("""">
                """),_display_(/*55.18*/gitbucket/*55.27*/.core.helper.html.checkicon(condition.priority == Some(None))),format.raw/*55.88*/(""" """),format.raw/*55.89*/("""Issues with no priority
              </a>
            </li>
            """),_display_(/*58.14*/priorities/*58.24*/.map/*58.28*/ { priority =>_display_(Seq[Any](format.raw/*58.42*/("""
              """),format.raw/*59.15*/("""<li>
                <a href=""""),_display_(/*60.27*/condition/*60.36*/.copy(priority = (if(condition.priority == Some(Some(priority.priorityName))) None else Some(Some(priority.priorityName)))).toURL),format.raw/*60.165*/("""""""),_display_(if(!priority.description.isEmpty)/*60.200*/ {_display_(Seq[Any](format.raw/*60.202*/(""" """),format.raw/*60.203*/("""title=""""),_display_(/*60.211*/priority/*60.219*/.description.get),format.raw/*60.235*/("""" """)))} else {null} ),format.raw/*60.238*/(""">
                  """),_display_(/*61.20*/gitbucket/*61.29*/.core.helper.html.checkicon(condition.priority == Some(Some(priority.priorityName)))),format.raw/*61.113*/("""
                  """),format.raw/*62.19*/("""<span style="background-color: #"""),_display_(/*62.52*/priority/*62.60*/.color),format.raw/*62.66*/(""";" class="label-color">&nbsp;&nbsp;</span>
                  """),_display_(/*63.20*/priority/*63.28*/.priorityName),format.raw/*63.41*/("""
                """),format.raw/*64.17*/("""</a>
              </li>
            """)))}),format.raw/*66.14*/("""
          """)))}),format.raw/*67.12*/("""
          """),_display_(/*68.12*/gitbucket/*68.21*/.core.helper.html.dropdown("Milestone", filter = ("milestone", "Find Milestone..."))/*68.105*/ {_display_(Seq[Any](format.raw/*68.107*/("""
            """),format.raw/*69.13*/("""<li>
              <a href=""""),_display_(/*70.25*/condition/*70.34*/.copy(milestone = (if(condition.milestone == Some(None)) None else Some(None))).toURL),format.raw/*70.119*/("""">
                """),_display_(/*71.18*/gitbucket/*71.27*/.core.helper.html.checkicon(condition.milestone == Some(None))),format.raw/*71.89*/(""" """),format.raw/*71.90*/("""Issues with no milestone
              </a>
            </li>
            """),_display_(/*74.14*/milestones/*74.24*/.filter(_.closedDate.isEmpty).map/*74.57*/ { milestone =>_display_(Seq[Any](format.raw/*74.72*/("""
              """),format.raw/*75.15*/("""<li>
                <a href=""""),_display_(/*76.27*/condition/*76.36*/.copy(milestone = (if(condition.milestone == Some(Some(milestone.title))) None else Some(Some(milestone.title)))).toURL),format.raw/*76.155*/("""">
                  """),_display_(/*77.20*/gitbucket/*77.29*/.core.helper.html.checkicon(condition.milestone == Some(Some(milestone.title)))),format.raw/*77.108*/(""" """),_display_(/*77.110*/milestone/*77.119*/.title),format.raw/*77.125*/("""
                """),format.raw/*78.17*/("""</a>
              </li>
            """)))}),format.raw/*80.14*/("""
          """)))}),format.raw/*81.12*/("""
          """),_display_(/*82.12*/gitbucket/*82.21*/.core.helper.html.dropdown("Assignee", filter = ("assignee", "Find Assignee..."))/*82.102*/ {_display_(Seq[Any](format.raw/*82.104*/("""
            """),format.raw/*83.13*/("""<li>
              <a href=""""),_display_(/*84.25*/condition/*84.34*/.copy(assigned = (if(condition.assigned == Some(None)) None else Some(None))).toURL),format.raw/*84.117*/("""">
                """),_display_(/*85.18*/gitbucket/*85.27*/.core.helper.html.checkicon(condition.assigned == Some(None))),format.raw/*85.88*/(""" """),format.raw/*85.89*/("""Assigned to nobody
              </a>
            </li>
            """),_display_(/*88.14*/collaborators/*88.27*/.map/*88.31*/ { collaborator =>_display_(Seq[Any](format.raw/*88.49*/("""
              """),format.raw/*89.15*/("""<li>
                <a href=""""),_display_(/*90.27*/condition/*90.36*/.copy(assigned = (if(condition.assigned == Some(Some(collaborator))) None else Some(Some(collaborator)))).toURL),format.raw/*90.147*/("""">
                  """),_display_(/*91.20*/gitbucket/*91.29*/.core.helper.html.checkicon(condition.assigned == Some(Some(collaborator)))),format.raw/*91.104*/("""
                  """),_display_(/*92.20*/helpers/*92.27*/.avatar(collaborator, 20)),format.raw/*92.52*/(""" """),_display_(/*92.54*/collaborator),format.raw/*92.66*/("""
                """),format.raw/*93.17*/("""</a>
              </li>
            """)))}),format.raw/*95.14*/("""
          """)))}),format.raw/*96.12*/("""
          """),_display_(/*97.12*/gitbucket/*97.21*/.core.helper.html.dropdown("Sort")/*97.55*/{_display_(Seq[Any](format.raw/*97.56*/("""
            """),format.raw/*98.13*/("""<li>
              <a href=""""),_display_(/*99.25*/condition/*99.34*/.copy(sort="created",  direction="desc").toURL),format.raw/*99.80*/("""">
                """),_display_(/*100.18*/gitbucket/*100.27*/.core.helper.html.checkicon(condition.sort == "created"  && condition.direction == "desc")),format.raw/*100.117*/(""" """),format.raw/*100.118*/("""Newest
              </a>
            </li>
            <li>
              <a href=""""),_display_(/*104.25*/condition/*104.34*/.copy(sort="created",  direction="asc" ).toURL),format.raw/*104.80*/("""">
                """),_display_(/*105.18*/gitbucket/*105.27*/.core.helper.html.checkicon(condition.sort == "created"  && condition.direction == "asc")),format.raw/*105.116*/(""" """),format.raw/*105.117*/("""Oldest
              </a>
            </li>
            <li>
              <a href=""""),_display_(/*109.25*/condition/*109.34*/.copy(sort="priority", direction="asc").toURL),format.raw/*109.79*/("""">
                """),_display_(/*110.18*/gitbucket/*110.27*/.core.helper.html.checkicon(condition.sort == "priority"  && condition.direction == "asc")),format.raw/*110.117*/(""" """),format.raw/*110.118*/("""Highest priority
              </a>
            </li>
            <li>
              <a href=""""),_display_(/*114.25*/condition/*114.34*/.copy(sort="priority", direction="desc" ).toURL),format.raw/*114.81*/("""">
                """),_display_(/*115.18*/gitbucket/*115.27*/.core.helper.html.checkicon(condition.sort == "priority"  && condition.direction == "desc")),format.raw/*115.118*/(""" """),format.raw/*115.119*/("""Lowest priority
              </a>
            </li>
            <li>
              <a href=""""),_display_(/*119.25*/condition/*119.34*/.copy(sort="comments", direction="desc").toURL),format.raw/*119.80*/("""">
                """),_display_(/*120.18*/gitbucket/*120.27*/.core.helper.html.checkicon(condition.sort == "comments"  && condition.direction == "desc")),format.raw/*120.118*/(""" """),format.raw/*120.119*/("""Most commented
              </a>
            </li>
            <li>
              <a href=""""),_display_(/*124.25*/condition/*124.34*/.copy(sort="comments", direction="asc" ).toURL),format.raw/*124.80*/("""">
                """),_display_(/*125.18*/gitbucket/*125.27*/.core.helper.html.checkicon(condition.sort == "comments"  && condition.direction == "asc")),format.raw/*125.117*/(""" """),format.raw/*125.118*/("""Least commented
              </a>
            </li>
            <li>
              <a href=""""),_display_(/*129.25*/condition/*129.34*/.copy(sort="updated",  direction="desc").toURL),format.raw/*129.80*/("""">
                """),_display_(/*130.18*/gitbucket/*130.27*/.core.helper.html.checkicon(condition.sort == "updated"  && condition.direction == "desc")),format.raw/*130.117*/(""" """),format.raw/*130.118*/("""Recently updated
              </a>
            </li>
            <li>
              <a href=""""),_display_(/*134.25*/condition/*134.34*/.copy(sort="updated",  direction="asc" ).toURL),format.raw/*134.80*/("""">
                """),_display_(/*135.18*/gitbucket/*135.27*/.core.helper.html.checkicon(condition.sort == "updated"  && condition.direction == "asc")),format.raw/*135.116*/(""" """),format.raw/*135.117*/("""Least recently updated
              </a>
            </li>
          """)))}),format.raw/*138.12*/("""
        """),format.raw/*139.9*/("""</span>
        """),_display_(if(isManageable)/*140.26*/{_display_(Seq[Any](format.raw/*140.27*/("""
          """),format.raw/*141.11*/("""<span id="table-issues-batchedit">
            """),_display_(/*142.14*/gitbucket/*142.23*/.core.helper.html.dropdown("Mark as")/*142.60*/ {_display_(Seq[Any](format.raw/*142.62*/("""
              """),format.raw/*143.15*/("""<li><a href="javascript:void(0);" class="toggle-state" data-id="open">Open</a></li>
              <li><a href="javascript:void(0);" class="toggle-state" data-id="close">Close</a></li>
            """)))}),format.raw/*145.14*/("""
            """),_display_(/*146.14*/gitbucket/*146.23*/.core.helper.html.dropdown("Label", filter = ("label", "Find Label..."))/*146.95*/ {_display_(Seq[Any](format.raw/*146.97*/("""
              """),_display_(/*147.16*/labels/*147.22*/.map/*147.26*/ { label =>_display_(Seq[Any](format.raw/*147.37*/("""
                """),format.raw/*148.17*/("""<li>
                  <a href="javascript:void(0);" class="toggle-label" data-id=""""),_display_(/*149.80*/label/*149.85*/.labelId),format.raw/*149.93*/("""">
                    <i class="octicon"></i>
                    <span class="label" style="background-color: #"""),_display_(/*151.68*/label/*151.73*/.color),format.raw/*151.79*/(""";">&nbsp;</span>
                    """),_display_(/*152.22*/label/*152.27*/.labelName),format.raw/*152.37*/("""
                  """),format.raw/*153.19*/("""</a>
                </li>
              """)))}),format.raw/*155.16*/("""
            """)))}),format.raw/*156.14*/("""
            """),_display_(/*157.14*/gitbucket/*157.23*/.core.helper.html.dropdown("Priority", filter = ("priority", "Find Priority..."))/*157.104*/ {_display_(Seq[Any](format.raw/*157.106*/("""
              """),format.raw/*158.15*/("""<li><a href="javascript:void(0);" class="toggle-priority" data-id="">No priority</a></li>
              """),_display_(/*159.16*/priorities/*159.26*/.map/*159.30*/ { priority =>_display_(Seq[Any](format.raw/*159.44*/("""
                """),format.raw/*160.17*/("""<li><a href="javascript:void(0);" class="toggle-priority" data-id=""""),_display_(/*160.85*/priority/*160.93*/.priorityId),format.raw/*160.104*/("""""""),_display_(if(!priority.description.isEmpty)/*160.139*/ {_display_(Seq[Any](format.raw/*160.141*/(""" """),format.raw/*160.142*/("""title=""""),_display_(/*160.150*/priority/*160.158*/.description.get),format.raw/*160.174*/("""" """)))} else {null} ),format.raw/*160.177*/(""">
                  <span style="background-color: #"""),_display_(/*161.52*/priority/*161.60*/.color),format.raw/*161.66*/(""";" class="label">&nbsp;</span>
                  """),_display_(/*162.20*/priority/*162.28*/.priorityName),format.raw/*162.41*/("""</a></li>
              """)))}),format.raw/*163.16*/("""
            """)))}),format.raw/*164.14*/("""
            """),_display_(/*165.14*/gitbucket/*165.23*/.core.helper.html.dropdown("Milestone", filter = ("milestone", "Find Milestone..."))/*165.107*/ {_display_(Seq[Any](format.raw/*165.109*/("""
              """),format.raw/*166.15*/("""<li><a href="javascript:void(0);" class="toggle-milestone" data-id="">No milestone</a></li>
              """),_display_(/*167.16*/milestones/*167.26*/.filter(_.closedDate.isEmpty).map/*167.59*/ { milestone =>_display_(Seq[Any](format.raw/*167.74*/("""
                """),format.raw/*168.17*/("""<li><a href="javascript:void(0);" class="toggle-milestone" data-id=""""),_display_(/*168.86*/milestone/*168.95*/.milestoneId),format.raw/*168.107*/("""">"""),_display_(/*168.110*/milestone/*168.119*/.title),format.raw/*168.125*/("""</a></li>
              """)))}),format.raw/*169.16*/("""
            """)))}),format.raw/*170.14*/("""
            """),_display_(/*171.14*/gitbucket/*171.23*/.core.helper.html.dropdown("Assignee", filter = ("assignee", "Find Assignee..."))/*171.104*/ {_display_(Seq[Any](format.raw/*171.106*/("""
              """),format.raw/*172.15*/("""<li><a href="javascript:void(0);" class="toggle-assign" data-name=""><i class="octicon octicon-x"></i> Clear assignee</a></li>
              """),_display_(/*173.16*/collaborators/*173.29*/.map/*173.33*/ { collaborator =>_display_(Seq[Any](format.raw/*173.51*/("""
                """),format.raw/*174.17*/("""<li><a href="javascript:void(0);" class="toggle-assign" data-name=""""),_display_(/*174.85*/collaborator),format.raw/*174.97*/(""""><i class="octicon"></i>"""),_display_(/*174.123*/helpers/*174.130*/.avatar(collaborator, 20)),format.raw/*174.155*/(""" """),_display_(/*174.157*/collaborator),format.raw/*174.169*/("""</a></li>
              """)))}),format.raw/*175.16*/("""
            """)))}),format.raw/*176.14*/("""
          """),format.raw/*177.11*/("""</span>
        """)))} else {null} ),format.raw/*178.10*/("""
      """),format.raw/*179.7*/("""</th>
    </tr>
  </thead>
  <tbody>
    """),_display_(if(issues.isEmpty)/*183.24*/{_display_(Seq[Any](format.raw/*183.25*/("""
      """),format.raw/*184.7*/("""<tr>
        <td style="padding: 20px; background-color: #eee; text-align: center;">
          """),_display_(if(target == "issues")/*186.34*/{_display_(Seq[Any](format.raw/*186.35*/("""
            """),format.raw/*187.13*/("""No issues to show.
          """)))}else/*188.18*/{_display_(Seq[Any](format.raw/*188.19*/("""
            """),format.raw/*189.13*/("""No pull requests to show.
          """)))}),format.raw/*190.12*/("""
          """),format.raw/*195.13*/("""
            """),_display_(if(repository.isDefined)/*196.38*/{_display_(Seq[Any](format.raw/*196.39*/("""
              """),_display_(if(target == "issues")/*197.38*/{_display_(Seq[Any](format.raw/*197.39*/("""
                """),format.raw/*198.17*/("""<a href=""""),_display_(/*198.27*/helpers/*198.34*/.url(repository.get)),format.raw/*198.54*/("""/issues/new">Create a new issue.</a>
              """)))}else/*199.22*/{_display_(Seq[Any](format.raw/*199.23*/("""
                """),format.raw/*200.17*/("""<a href=""""),_display_(/*200.27*/helpers/*200.34*/.url(repository.get)),format.raw/*200.54*/("""/compare">Create a new pull request.</a>
              """)))}),format.raw/*201.16*/("""
            """)))} else {null} ),format.raw/*202.14*/("""
          """),format.raw/*205.13*/("""
        """),format.raw/*206.9*/("""</td>
      </tr>
    """)))} else {null} ),format.raw/*208.6*/("""
    """),_display_(/*209.6*/issues/*209.12*/.map/*209.16*/ { case (IssueInfo(issue, labels, milestone, priority, commentCount, commitId, assignedUserNames), status) =>_display_(Seq[Any](format.raw/*209.125*/("""
      """),format.raw/*210.7*/("""<tr>
        <td style="padding-top: 12px; padding-bottom: 12px;">
          """),_display_(if(isManageable)/*212.28*/{_display_(Seq[Any](format.raw/*212.29*/("""
            """),format.raw/*213.13*/("""<input type="checkbox" value=""""),_display_(/*213.44*/issue/*213.49*/.issueId),format.raw/*213.57*/("""" aria-labelledby="issue_"""),_display_(/*213.83*/(issue.issueId)),format.raw/*213.98*/("""_link"/>
          """)))} else {null} ),format.raw/*214.12*/("""
          """),format.raw/*217.13*/("""
          """),_display_(if(repository.isEmpty)/*218.34*/{_display_(Seq[Any](format.raw/*218.35*/("""
            """),format.raw/*219.13*/("""<a href=""""),_display_(/*219.23*/context/*219.30*/.path),format.raw/*219.35*/("""/"""),_display_(/*219.37*/issue/*219.42*/.userName),format.raw/*219.51*/("""/"""),_display_(/*219.53*/issue/*219.58*/.repositoryName),format.raw/*219.73*/("""">"""),_display_(/*219.76*/issue/*219.81*/.repositoryName),format.raw/*219.96*/("""</a>&nbsp;&#xFF65;
          """)))} else {null} ),format.raw/*220.12*/("""
          """),_display_(if(target == "issues")/*221.34*/{_display_(Seq[Any](format.raw/*221.35*/("""
            """),format.raw/*222.13*/("""<a id="issue_"""),_display_(/*222.27*/(issue.issueId)),format.raw/*222.42*/("""_link" href=""""),_display_(/*222.56*/context/*222.63*/.path),format.raw/*222.68*/("""/"""),_display_(/*222.70*/issue/*222.75*/.userName),format.raw/*222.84*/("""/"""),_display_(/*222.86*/issue/*222.91*/.repositoryName),format.raw/*222.106*/("""/issues/"""),_display_(/*222.115*/issue/*222.120*/.issueId),format.raw/*222.128*/("""" class="issue-title">"""),_display_(/*222.151*/issue/*222.156*/.title),format.raw/*222.162*/("""</a>
          """)))}else/*223.18*/{_display_(Seq[Any](format.raw/*223.19*/("""
            """),format.raw/*224.13*/("""<a id="issue_"""),_display_(/*224.27*/(issue.issueId)),format.raw/*224.42*/("""_link" href=""""),_display_(/*224.56*/context/*224.63*/.path),format.raw/*224.68*/("""/"""),_display_(/*224.70*/issue/*224.75*/.userName),format.raw/*224.84*/("""/"""),_display_(/*224.86*/issue/*224.91*/.repositoryName),format.raw/*224.106*/("""/pull/"""),_display_(/*224.113*/issue/*224.118*/.issueId),format.raw/*224.126*/("""" class="issue-title">"""),_display_(/*224.149*/issue/*224.154*/.title),format.raw/*224.160*/("""</a>
          """)))}),format.raw/*225.12*/("""
          """),_display_(/*226.12*/status/*226.18*/.map/*226.22*/ { case (summary, statuses) =>_display_(Seq[Any](format.raw/*226.52*/("""
            """),_display_(/*227.14*/gitbucket/*227.23*/.core.helper.html.commitstatus(commitId.get, summary, statuses)),format.raw/*227.86*/("""
          """)))}),format.raw/*228.12*/("""
          """),_display_(/*229.12*/labels/*229.18*/.map/*229.22*/ { label =>_display_(Seq[Any](format.raw/*229.33*/("""
            """),format.raw/*230.13*/("""<span class="label-color small" style="background-color: #"""),_display_(/*230.72*/label/*230.77*/.color),format.raw/*230.83*/("""; color: #"""),_display_(/*230.94*/label/*230.99*/.fontColor),format.raw/*230.109*/("""; padding-left: 4px; padding-right: 4px">"""),_display_(/*230.151*/label/*230.156*/.labelName),format.raw/*230.166*/("""</span>
          """)))}),format.raw/*231.12*/("""
          """),format.raw/*232.11*/("""<span class="pull-right small">
            """),_display_(/*233.14*/assignedUserNames/*233.31*/.map/*233.35*/ { userName =>_display_(Seq[Any](format.raw/*233.49*/("""
              """),_display_(/*234.16*/helpers/*234.23*/.avatar(userName, 20, tooltip = true)),format.raw/*234.60*/("""
            """)))}),format.raw/*235.14*/("""
            """),_display_(if(commentCount > 0)/*236.34*/{_display_(Seq[Any](format.raw/*236.35*/("""
              """),format.raw/*237.15*/("""<a href=""""),_display_(/*237.25*/context/*237.32*/.path),format.raw/*237.37*/("""/"""),_display_(/*237.39*/issue/*237.44*/.userName),format.raw/*237.53*/("""/"""),_display_(/*237.55*/issue/*237.60*/.repositoryName),format.raw/*237.75*/("""/issues/"""),_display_(/*237.84*/issue/*237.89*/.issueId),format.raw/*237.97*/("""" class="issue-comment-count">
                <i class="octicon octicon-comment active"></i> """),_display_(/*238.65*/commentCount),format.raw/*238.77*/("""
              """),format.raw/*239.15*/("""</a>
            """)))}else/*240.20*/{_display_(Seq[Any](format.raw/*240.21*/("""
              """),format.raw/*241.15*/("""<a href=""""),_display_(/*241.25*/context/*241.32*/.path),format.raw/*241.37*/("""/"""),_display_(/*241.39*/issue/*241.44*/.userName),format.raw/*241.53*/("""/"""),_display_(/*241.55*/issue/*241.60*/.repositoryName),format.raw/*241.75*/("""/issues/"""),_display_(/*241.84*/issue/*241.89*/.issueId),format.raw/*241.97*/("""" class="issue-comment-count" style="color: silver;">
                <i class="octicon octicon-comment"></i> """),_display_(/*242.58*/commentCount),format.raw/*242.70*/("""
              """),format.raw/*243.15*/("""</a>
            """)))}),format.raw/*244.14*/("""
          """),format.raw/*245.11*/("""</span>
          <div class="small muted" style="margin-left: 12px; margin-top: 2px;">
            #"""),_display_(/*247.15*/issue/*247.20*/.issueId),format.raw/*247.28*/(""" """),format.raw/*247.29*/("""opened """),_display_(/*247.37*/gitbucket/*247.46*/.core.helper.html.datetimeago(issue.registeredDate)),format.raw/*247.97*/(""" """),format.raw/*247.98*/("""by """),_display_(/*247.102*/helpers/*247.109*/.user(issue.openedUserName, styleClass="username")),format.raw/*247.159*/("""
            """),_display_(/*248.14*/priority/*248.22*/.map(priority => priorities.filter(p => p.priorityName == priority).head).map/*248.99*/ { priority =>_display_(Seq[Any](format.raw/*248.113*/("""
            """),format.raw/*249.13*/("""<span style="margin: 20px;"><a href=""""),_display_(/*249.51*/condition/*249.60*/.copy(priority = Some(Some(priority.priorityName))).toURL),format.raw/*249.117*/("""" class="username""""),_display_(if(!priority.description.isEmpty)/*249.169*/ {_display_(Seq[Any](format.raw/*249.171*/(""" """),format.raw/*249.172*/("""title=""""),_display_(/*249.180*/priority/*249.188*/.description.get),format.raw/*249.204*/("""" """)))} else {null} ),format.raw/*249.207*/("""><i class="octicon octicon-flame"></i>
              <span class="issue-priority issue-priority-inline" style="background-color: #"""),_display_(/*250.93*/priority/*250.101*/.color),format.raw/*250.107*/("""; color: #"""),_display_(/*250.118*/priority/*250.126*/.fontColor),format.raw/*250.136*/(""";">"""),_display_(/*250.140*/priority/*250.148*/.priorityName),format.raw/*250.161*/("""</span></a></span>
            """)))}),format.raw/*251.14*/("""
            """),_display_(/*252.14*/milestone/*252.23*/.map/*252.27*/ { milestone =>_display_(Seq[Any](format.raw/*252.42*/("""
              """),format.raw/*253.15*/("""<span style="margin: 20px;"><a href=""""),_display_(/*253.53*/condition/*253.62*/.copy(milestone = Some(Some(milestone))).toURL),format.raw/*253.108*/("""" class="username"><i class="octicon octicon-milestone"></i> """),_display_(/*253.170*/milestone),format.raw/*253.179*/("""</a></span>
            """)))}),format.raw/*254.14*/("""
          """),format.raw/*255.11*/("""</div>
        </td>
      </tr>
    """)))}),format.raw/*258.6*/("""
  """),format.raw/*259.3*/("""</tbody>
</table>
<div class="pull-right">
  """),_display_(/*262.4*/gitbucket/*262.13*/.core.helper.html.paginator(page, (if(condition.state == "open") openCount else closedCount), gitbucket.core.service.IssuesService.IssueLimit, 10, condition.toURL)),format.raw/*262.176*/("""
"""),format.raw/*263.1*/("""</div>
"""))
      }
    }
  }

  def render(target:String,issues:List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],page:Int,openCount:Int,closedCount:Int,condition:gitbucket.core.service.IssuesService.IssueSearchCondition,collaborators:List[String],milestones:List[gitbucket.core.model.Milestone],priorities:List[gitbucket.core.model.Priority],labels:List[gitbucket.core.model.Label],repository:Option[gitbucket.core.service.RepositoryService.RepositoryInfo],isManageable:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(target,issues,page,openCount,closedCount,condition,collaborators,milestones,priorities,labels,repository,isManageable)(context)

  def f:((String,List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],Int,Int,Int,gitbucket.core.service.IssuesService.IssueSearchCondition,List[String],List[gitbucket.core.model.Milestone],List[gitbucket.core.model.Priority],List[gitbucket.core.model.Label],Option[gitbucket.core.service.RepositoryService.RepositoryInfo],Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (target,issues,page,openCount,closedCount,condition,collaborators,milestones,priorities,labels,repository,isManageable) => (context) => apply(target,issues,page,openCount,closedCount,condition,collaborators,milestones,priorities,labels,repository,isManageable)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/issues/listparts.scala.html
                  HASH: 63cfdc498a977bb3c82b413e61c97df7d6d2d5ae
                  MATRIX: 1022->1|1760->667|1803->703|1886->1083|1914->1084|2181->1324|2199->1333|2283->1408|2323->1410|2364->1424|2386->1437|2399->1441|2455->1459|2498->1474|2556->1505|2574->1514|2691->1609|2740->1631|2758->1640|2846->1707|2893->1727|2909->1734|2955->1759|2984->1761|3017->1773|3062->1790|3131->1828|3174->1840|3213->1852|3231->1861|3312->1933|3352->1935|3393->1949|3408->1955|3421->1959|3470->1970|3513->1985|3571->2016|3589->2025|3756->2170|3805->2192|3823->2201|3916->2272|3963->2291|4023->2324|4037->2329|4064->2335|4153->2397|4167->2402|4198->2412|4243->2429|4312->2467|4355->2479|4394->2491|4412->2500|4503->2581|4544->2583|4585->2596|4641->2625|4659->2634|4764->2717|4811->2737|4829->2746|4911->2807|4940->2808|5041->2882|5060->2892|5073->2896|5125->2910|5168->2925|5226->2956|5244->2965|5395->3094|5458->3129|5499->3131|5529->3132|5565->3140|5583->3148|5621->3164|5669->3167|5717->3188|5735->3197|5841->3281|5888->3300|5948->3333|5965->3341|5992->3347|6081->3409|6098->3417|6132->3430|6177->3447|6246->3485|6289->3497|6328->3509|6346->3518|6440->3602|6481->3604|6522->3617|6578->3646|6596->3655|6703->3740|6750->3760|6768->3769|6851->3831|6880->3832|6982->3907|7001->3917|7043->3950|7096->3965|7139->3980|7197->4011|7215->4020|7356->4139|7405->4161|7423->4170|7524->4249|7554->4251|7573->4260|7601->4266|7646->4283|7715->4321|7758->4333|7797->4345|7815->4354|7906->4435|7947->4437|7988->4450|8044->4479|8062->4488|8167->4571|8214->4591|8232->4600|8314->4661|8343->4662|8439->4731|8461->4744|8474->4748|8530->4766|8573->4781|8631->4812|8649->4821|8782->4932|8831->4954|8849->4963|8946->5038|8993->5058|9009->5065|9055->5090|9084->5092|9117->5104|9162->5121|9231->5159|9274->5171|9313->5183|9331->5192|9374->5226|9413->5227|9454->5240|9510->5269|9528->5278|9595->5324|9643->5344|9662->5353|9775->5443|9806->5444|9919->5529|9938->5538|10006->5584|10054->5604|10073->5613|10185->5702|10216->5703|10329->5788|10348->5797|10415->5842|10463->5862|10482->5871|10595->5961|10626->5962|10749->6057|10768->6066|10837->6113|10885->6133|10904->6142|11018->6233|11049->6234|11171->6328|11190->6337|11258->6383|11306->6403|11325->6412|11439->6503|11470->6504|11591->6597|11610->6606|11678->6652|11726->6672|11745->6681|11858->6771|11889->6772|12011->6866|12030->6875|12098->6921|12146->6941|12165->6950|12278->7040|12309->7041|12432->7136|12451->7145|12519->7191|12567->7211|12586->7220|12698->7309|12729->7310|12832->7381|12869->7390|12930->7423|12970->7424|13010->7435|13086->7483|13105->7492|13152->7529|13193->7531|13237->7546|13466->7743|13508->7757|13527->7766|13609->7838|13650->7840|13694->7856|13710->7862|13724->7866|13774->7877|13820->7894|13932->7978|13947->7983|13977->7991|14119->8105|14134->8110|14162->8116|14228->8154|14243->8159|14275->8169|14323->8188|14397->8230|14443->8244|14485->8258|14504->8267|14596->8348|14638->8350|14682->8365|14815->8470|14835->8480|14849->8484|14902->8498|14948->8515|15044->8583|15062->8591|15096->8602|15160->8637|15202->8639|15233->8640|15270->8648|15289->8656|15328->8672|15377->8675|15458->8728|15476->8736|15504->8742|15582->8792|15600->8800|15635->8813|15692->8838|15738->8852|15780->8866|15799->8875|15894->8959|15936->8961|15980->8976|16115->9083|16135->9093|16178->9126|16232->9141|16278->9158|16375->9227|16394->9236|16429->9248|16461->9251|16481->9260|16510->9266|16567->9291|16613->9305|16655->9319|16674->9328|16766->9409|16808->9411|16852->9426|17022->9568|17045->9581|17059->9585|17116->9603|17162->9620|17258->9688|17292->9700|17347->9726|17365->9733|17413->9758|17444->9760|17479->9772|17536->9797|17582->9811|17622->9822|17684->9839|17719->9846|17807->9906|17847->9907|17882->9914|18028->10032|18068->10033|18110->10046|18164->10082|18204->10083|18246->10096|18315->10133|18355->10361|18421->10399|18461->10400|18527->10438|18567->10439|18613->10456|18651->10466|18668->10473|18710->10493|18786->10551|18826->10552|18872->10569|18910->10579|18927->10586|18969->10606|19057->10662|19116->10676|19156->10714|19193->10723|19260->10746|19293->10752|19309->10758|19323->10762|19472->10871|19507->10878|19629->10972|19669->10973|19711->10986|19770->11017|19785->11022|19815->11030|19869->11056|19906->11071|19971->11091|20011->11235|20073->11269|20113->11270|20155->11283|20193->11293|20210->11300|20237->11305|20267->11307|20282->11312|20313->11321|20343->11323|20358->11328|20395->11343|20426->11346|20441->11351|20478->11366|20553->11396|20615->11430|20655->11431|20697->11444|20739->11458|20776->11473|20818->11487|20835->11494|20862->11499|20892->11501|20907->11506|20938->11515|20968->11517|20983->11522|21021->11537|21059->11546|21075->11551|21106->11559|21158->11582|21174->11587|21203->11593|21243->11615|21283->11616|21325->11629|21367->11643|21404->11658|21446->11672|21463->11679|21490->11684|21520->11686|21535->11691|21566->11700|21596->11702|21611->11707|21649->11722|21685->11729|21701->11734|21732->11742|21784->11765|21800->11770|21829->11776|21877->11792|21917->11804|21933->11810|21947->11814|22016->11844|22058->11858|22077->11867|22162->11930|22206->11942|22246->11954|22262->11960|22276->11964|22326->11975|22368->11988|22455->12047|22470->12052|22498->12058|22537->12069|22552->12074|22585->12084|22656->12126|22672->12131|22705->12141|22756->12160|22796->12171|22869->12216|22896->12233|22910->12237|22963->12251|23007->12267|23024->12274|23083->12311|23129->12325|23191->12359|23231->12360|23275->12375|23313->12385|23330->12392|23357->12397|23387->12399|23402->12404|23433->12413|23463->12415|23478->12420|23515->12435|23552->12444|23567->12449|23597->12457|23720->12552|23754->12564|23798->12579|23840->12603|23880->12604|23924->12619|23962->12629|23979->12636|24006->12641|24036->12643|24051->12648|24082->12657|24112->12659|24127->12664|24164->12679|24201->12688|24216->12693|24246->12701|24385->12812|24419->12824|24463->12839|24513->12857|24553->12868|24683->12970|24698->12975|24728->12983|24758->12984|24794->12992|24813->13001|24886->13052|24916->13053|24949->13057|24967->13064|25040->13114|25082->13128|25100->13136|25187->13213|25241->13227|25283->13240|25349->13278|25368->13287|25448->13344|25529->13396|25571->13398|25602->13399|25639->13407|25658->13415|25697->13431|25746->13434|25905->13565|25924->13573|25953->13579|25993->13590|26012->13598|26045->13608|26078->13612|26097->13620|26133->13633|26197->13665|26239->13679|26258->13688|26272->13692|26326->13707|26370->13722|26436->13760|26455->13769|26524->13815|26615->13877|26647->13886|26704->13911|26744->13922|26813->13960|26844->13963|26917->14009|26936->14018|27122->14181|27151->14182
                  LINES: 14->1|28->13|29->14|32->24|33->25|39->31|39->31|39->31|39->31|40->32|40->32|40->32|40->32|41->33|42->34|42->34|42->34|43->35|43->35|43->35|44->36|44->36|44->36|44->36|44->36|45->37|47->39|48->40|49->41|49->41|49->41|49->41|50->42|50->42|50->42|50->42|51->43|52->44|52->44|52->44|53->45|53->45|53->45|54->46|54->46|54->46|54->46|55->47|55->47|55->47|56->48|58->50|59->51|60->52|60->52|60->52|60->52|61->53|62->54|62->54|62->54|63->55|63->55|63->55|63->55|66->58|66->58|66->58|66->58|67->59|68->60|68->60|68->60|68->60|68->60|68->60|68->60|68->60|68->60|68->60|69->61|69->61|69->61|70->62|70->62|70->62|70->62|71->63|71->63|71->63|72->64|74->66|75->67|76->68|76->68|76->68|76->68|77->69|78->70|78->70|78->70|79->71|79->71|79->71|79->71|82->74|82->74|82->74|82->74|83->75|84->76|84->76|84->76|85->77|85->77|85->77|85->77|85->77|85->77|86->78|88->80|89->81|90->82|90->82|90->82|90->82|91->83|92->84|92->84|92->84|93->85|93->85|93->85|93->85|96->88|96->88|96->88|96->88|97->89|98->90|98->90|98->90|99->91|99->91|99->91|100->92|100->92|100->92|100->92|100->92|101->93|103->95|104->96|105->97|105->97|105->97|105->97|106->98|107->99|107->99|107->99|108->100|108->100|108->100|108->100|112->104|112->104|112->104|113->105|113->105|113->105|113->105|117->109|117->109|117->109|118->110|118->110|118->110|118->110|122->114|122->114|122->114|123->115|123->115|123->115|123->115|127->119|127->119|127->119|128->120|128->120|128->120|128->120|132->124|132->124|132->124|133->125|133->125|133->125|133->125|137->129|137->129|137->129|138->130|138->130|138->130|138->130|142->134|142->134|142->134|143->135|143->135|143->135|143->135|146->138|147->139|148->140|148->140|149->141|150->142|150->142|150->142|150->142|151->143|153->145|154->146|154->146|154->146|154->146|155->147|155->147|155->147|155->147|156->148|157->149|157->149|157->149|159->151|159->151|159->151|160->152|160->152|160->152|161->153|163->155|164->156|165->157|165->157|165->157|165->157|166->158|167->159|167->159|167->159|167->159|168->160|168->160|168->160|168->160|168->160|168->160|168->160|168->160|168->160|168->160|168->160|169->161|169->161|169->161|170->162|170->162|170->162|171->163|172->164|173->165|173->165|173->165|173->165|174->166|175->167|175->167|175->167|175->167|176->168|176->168|176->168|176->168|176->168|176->168|176->168|177->169|178->170|179->171|179->171|179->171|179->171|180->172|181->173|181->173|181->173|181->173|182->174|182->174|182->174|182->174|182->174|182->174|182->174|182->174|183->175|184->176|185->177|186->178|187->179|191->183|191->183|192->184|194->186|194->186|195->187|196->188|196->188|197->189|198->190|199->195|200->196|200->196|201->197|201->197|202->198|202->198|202->198|202->198|203->199|203->199|204->200|204->200|204->200|204->200|205->201|206->202|207->205|208->206|210->208|211->209|211->209|211->209|211->209|212->210|214->212|214->212|215->213|215->213|215->213|215->213|215->213|215->213|216->214|217->217|218->218|218->218|219->219|219->219|219->219|219->219|219->219|219->219|219->219|219->219|219->219|219->219|219->219|219->219|219->219|220->220|221->221|221->221|222->222|222->222|222->222|222->222|222->222|222->222|222->222|222->222|222->222|222->222|222->222|222->222|222->222|222->222|222->222|222->222|222->222|222->222|223->223|223->223|224->224|224->224|224->224|224->224|224->224|224->224|224->224|224->224|224->224|224->224|224->224|224->224|224->224|224->224|224->224|224->224|224->224|224->224|225->225|226->226|226->226|226->226|226->226|227->227|227->227|227->227|228->228|229->229|229->229|229->229|229->229|230->230|230->230|230->230|230->230|230->230|230->230|230->230|230->230|230->230|230->230|231->231|232->232|233->233|233->233|233->233|233->233|234->234|234->234|234->234|235->235|236->236|236->236|237->237|237->237|237->237|237->237|237->237|237->237|237->237|237->237|237->237|237->237|237->237|237->237|237->237|238->238|238->238|239->239|240->240|240->240|241->241|241->241|241->241|241->241|241->241|241->241|241->241|241->241|241->241|241->241|241->241|241->241|241->241|242->242|242->242|243->243|244->244|245->245|247->247|247->247|247->247|247->247|247->247|247->247|247->247|247->247|247->247|247->247|247->247|248->248|248->248|248->248|248->248|249->249|249->249|249->249|249->249|249->249|249->249|249->249|249->249|249->249|249->249|249->249|250->250|250->250|250->250|250->250|250->250|250->250|250->250|250->250|250->250|251->251|252->252|252->252|252->252|252->252|253->253|253->253|253->253|253->253|253->253|253->253|254->254|255->255|258->258|259->259|262->262|262->262|262->262|263->263
                  -- GENERATED --
              */
          