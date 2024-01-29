
package gitbucket.core.issues.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
/*1.2*/import org.json4s.scalap.scalasig.ClassFileParser.field

object issueinfo extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template13[Option[gitbucket.core.model.Issue],List[gitbucket.core.model.Comment],List[gitbucket.core.model.Label],List[gitbucket.core.model.IssueAssignee],List[String],List[(gitbucket.core.model.Milestone, Int, Int)],List[gitbucket.core.model.Priority],Option[gitbucket.core.model.Priority],List[gitbucket.core.model.Label],List[(gitbucket.core.model.CustomField, Option[gitbucket.core.model.IssueCustomField])],Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(issue: Option[gitbucket.core.model.Issue],
  comments: List[gitbucket.core.model.Comment],
  issueLabels: List[gitbucket.core.model.Label],
  issueAssignees: List[gitbucket.core.model.IssueAssignee],
  collaborators: List[String],
  milestones: List[(gitbucket.core.model.Milestone, Int, Int)],
  priorities: List[gitbucket.core.model.Priority],
  defaultPriority: Option[gitbucket.core.model.Priority],
  labels: List[gitbucket.core.model.Label],
  customFields: List[(gitbucket.core.model.CustomField, Option[gitbucket.core.model.IssueCustomField])],
  isManageable: Boolean,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*14.2*/import gitbucket.core.view.helpers


Seq[Any](format.raw/*15.1*/("""<div style="margin-bottom: 14px;">
  <span class="muted small strong">Labels</span>
  """),_display_(if(isManageable)/*17.20*/{_display_(Seq[Any](format.raw/*17.21*/("""
    """),format.raw/*18.5*/("""<div class="pull-right">
      """),_display_(/*19.8*/gitbucket/*19.17*/.core.helper.html.dropdown("Edit", right = true, filter = ("labels", "Filter Labels"))/*19.103*/ {_display_(Seq[Any](format.raw/*19.105*/("""
        """),_display_(/*20.10*/labels/*20.16*/.map/*20.20*/ { label =>_display_(Seq[Any](format.raw/*20.31*/("""
          """),format.raw/*21.11*/("""<li>
            <a href="#" class="toggle-label" data-label-id=""""),_display_(/*22.62*/label/*22.67*/.labelId),format.raw/*22.75*/("""">
              """),_display_(/*23.16*/gitbucket/*23.25*/.core.helper.html.checkicon(issueLabels.exists(_.labelId == label.labelId))),format.raw/*23.100*/("""
              """),format.raw/*24.15*/("""<span class="label" style="background-color: #"""),_display_(/*24.62*/label/*24.67*/.color),format.raw/*24.73*/(""";">&nbsp;</span>
              """),_display_(/*25.16*/label/*25.21*/.labelName),format.raw/*25.31*/("""
            """),format.raw/*26.13*/("""</a>
          </li>
        """)))}),format.raw/*28.10*/("""
      """)))}),format.raw/*29.8*/("""
      """),_display_(if(issue.isEmpty)/*30.25*/{_display_(Seq[Any](format.raw/*30.26*/("""
        """),format.raw/*31.9*/("""<input type="hidden" name="labelNames" value=""/>
      """)))} else {null} ),format.raw/*32.8*/("""
    """),format.raw/*33.5*/("""</div>
  """)))} else {null} ),format.raw/*34.4*/("""
"""),format.raw/*35.1*/("""</div>
<ul class="label-list nav nav-pills nav-stacked">
  """),_display_(/*37.4*/gitbucket/*37.13*/.core.issues.html.labellist(issueLabels)),format.raw/*37.53*/("""
"""),format.raw/*38.1*/("""</ul>
<hr/>

<div style="margin-bottom: 14px;">
  <span class="muted small strong">Priority</span>
  """),_display_(if(isManageable)/*43.20*/{_display_(Seq[Any](format.raw/*43.21*/("""
    """),format.raw/*44.5*/("""<div class="pull-right">
      """),_display_(/*45.8*/gitbucket/*45.17*/.core.helper.html.dropdown("Edit", right = true, filter = ("priority", "Filter Priority"))/*45.107*/ {_display_(Seq[Any](format.raw/*45.109*/("""
        """),format.raw/*46.9*/("""<li><a href="javascript:void(0);" class="priority" data-id=""><i class="octicon octicon-x"></i> Clear priority</a></li>
        """),_display_(/*47.10*/priorities/*47.20*/.map/*47.24*/ { priority =>_display_(Seq[Any](format.raw/*47.38*/("""
          """),format.raw/*48.11*/("""<li>
            <a href="javascript:void(0);" class="priority" data-id=""""),_display_(/*49.70*/priority/*49.78*/.priorityId),format.raw/*49.89*/("""" data-name=""""),_display_(/*49.103*/priority/*49.111*/.priorityName),format.raw/*49.124*/("""" data-color="#"""),_display_(/*49.140*/priority/*49.148*/.color),format.raw/*49.154*/("""" data-font-color="#"""),_display_(/*49.175*/priority/*49.183*/.fontColor),format.raw/*49.193*/("""""""),_display_(if(!priority.description.isEmpty)/*49.228*/ {_display_(Seq[Any](format.raw/*49.230*/(""" """),format.raw/*49.231*/("""title=""""),_display_(/*49.239*/priority/*49.247*/.description.get),format.raw/*49.263*/("""" """)))} else {null} ),format.raw/*49.266*/(""">
              """),_display_(/*50.16*/gitbucket/*50.25*/.core.helper.html.checkicon(issue.flatMap(_.priorityId).orElse(defaultPriority.map(_.priorityId)).map(id => id == priority.priorityId).getOrElse(false))),format.raw/*50.177*/("""
              """),format.raw/*51.15*/("""<span class="label" style="background-color: #"""),_display_(/*51.62*/priority/*51.70*/.color),format.raw/*51.76*/(""";">&nbsp;</span>
              """),_display_(/*52.16*/priority/*52.24*/.priorityName),format.raw/*52.37*/("""
            """),format.raw/*53.13*/("""</a>
          </li>
        """)))}),format.raw/*55.10*/("""
      """)))}),format.raw/*56.8*/("""
    """),format.raw/*57.5*/("""</div>
  """)))} else {null} ),format.raw/*58.4*/("""
"""),format.raw/*59.1*/("""</div>
<span id="label-priority">
  """),_display_(/*61.4*/issue/*61.9*/.flatMap(_.priorityId).orElse(defaultPriority.map(_.priorityId)).map/*61.77*/ { priorityId =>_display_(Seq[Any](format.raw/*61.93*/("""
    """),_display_(/*62.6*/priorities/*62.16*/.collect/*62.24*/ {/*62.27*/case priority if(priority.priorityId == priorityId) =>/*62.81*/ {_display_(Seq[Any](format.raw/*62.83*/("""
      """),format.raw/*63.7*/("""<a class="issue-priority" style="background-color: #"""),_display_(/*63.60*/priority/*63.68*/.color),format.raw/*63.74*/("""; color: #"""),_display_(/*63.85*/priority/*63.93*/.fontColor),format.raw/*63.103*/(""";" href=""""),_display_(/*63.113*/helpers/*63.120*/.url(repository)),format.raw/*63.136*/("""/issues?priority="""),_display_(/*63.154*/helpers/*63.161*/.urlEncode(priority.priorityName)),format.raw/*63.194*/("""&state=open""""),_display_(if(!priority.description.isEmpty)/*63.240*/ {_display_(Seq[Any](format.raw/*63.242*/(""" """),format.raw/*63.243*/("""title=""""),_display_(/*63.251*/priority/*63.259*/.description.get),format.raw/*63.275*/("""" """)))} else {null} ),format.raw/*63.278*/(""">"""),_display_(/*63.280*/priority/*63.288*/.priorityName),format.raw/*63.301*/("""</a>
    """)))}}),format.raw/*64.7*/("""
  """)))}/*65.4*/.getOrElse/*65.14*/ {_display_(Seq[Any](format.raw/*65.16*/("""
    """),format.raw/*66.5*/("""<span class="muted small">No priority</span>
  """)))}),format.raw/*67.4*/("""
"""),format.raw/*68.1*/("""</span>
"""),_display_(if(issue.isEmpty)/*69.19*/{_display_(Seq[Any](format.raw/*69.20*/("""
  """),format.raw/*70.3*/("""<input type="hidden" name="priorityId" value=""""),_display_(/*70.50*/defaultPriority/*70.65*/.map(_.priorityId).map(_.toString).getOrElse("")),format.raw/*70.113*/(""""/>
""")))} else {null} ),format.raw/*71.2*/("""
"""),format.raw/*72.1*/("""<hr/>

<div style="margin-bottom: 14px;">
  <span class="muted small strong">Milestone</span>
  """),_display_(if(isManageable)/*76.20*/{_display_(Seq[Any](format.raw/*76.21*/("""
    """),format.raw/*77.5*/("""<div class="pull-right">
      """),_display_(/*78.8*/gitbucket/*78.17*/.core.helper.html.dropdown("Edit", right = true, filter = ("milestone", "Filter Milestone"))/*78.109*/ {_display_(Seq[Any](format.raw/*78.111*/("""
        """),format.raw/*79.9*/("""<li><a href="javascript:void(0);" class="milestone" data-id=""><i class="octicon octicon-x"></i> Clear this milestone</a></li>
        """),_display_(/*80.10*/milestones/*80.20*/.filter(_._1.closedDate.isEmpty).map/*80.56*/ { case (milestone, _, _) =>_display_(Seq[Any](format.raw/*80.84*/("""
          """),format.raw/*81.11*/("""<li>
            <a href="javascript:void(0);" class="milestone" data-id=""""),_display_(/*82.71*/milestone/*82.80*/.milestoneId),format.raw/*82.92*/("""" data-title=""""),_display_(/*82.107*/milestone/*82.116*/.title),format.raw/*82.122*/("""">
              """),_display_(/*83.16*/issue/*83.21*/.map/*83.25*/ { issue =>_display_(Seq[Any](format.raw/*83.36*/("""
                """),_display_(/*84.18*/gitbucket/*84.27*/.core.helper.html.checkicon(Some(milestone.milestoneId) == issue.milestoneId)),format.raw/*84.104*/("""
              """)))}),format.raw/*85.16*/("""
              """),_display_(/*86.16*/milestone/*86.25*/.title),format.raw/*86.31*/("""
              """),format.raw/*87.15*/("""<div class="small" style="padding-left: 20px;">
                """),_display_(/*88.18*/milestone/*88.27*/.dueDate.map/*88.39*/ { dueDate =>_display_(Seq[Any](format.raw/*88.52*/("""
                  """),_display_(if(helpers.isPast(dueDate))/*89.47*/{_display_(Seq[Any](format.raw/*89.48*/("""
                    """),format.raw/*90.21*/("""<i class="octicon octicon-alert" style="color:#BD2C00;"></i>
                    <span class="milestone-alert">Due by """),_display_(/*91.59*/helpers/*91.66*/.date(dueDate)),format.raw/*91.80*/("""</span>
                  """)))}else/*92.26*/{_display_(Seq[Any](format.raw/*92.27*/("""
                    """),format.raw/*93.21*/("""<span class="muted">Due by """),_display_(/*93.49*/helpers/*93.56*/.date(dueDate)),format.raw/*93.70*/("""</span>
                  """)))}),format.raw/*94.20*/("""
                """)))}/*95.18*/.getOrElse/*95.28*/ {_display_(Seq[Any](format.raw/*95.30*/("""
                  """),format.raw/*96.19*/("""<span class="muted">No due date</span>
                """)))}),format.raw/*97.18*/("""
              """),format.raw/*98.15*/("""</div>
            </a>
          </li>
        """)))}),format.raw/*101.10*/("""
      """)))}),format.raw/*102.8*/("""
    """),format.raw/*103.5*/("""</div>
  """)))} else {null} ),format.raw/*104.4*/("""
"""),format.raw/*105.1*/("""</div>
<div id="milestone-progress-area">
  """),_display_(/*107.4*/issue/*107.9*/.flatMap(_.milestoneId).map/*107.36*/ { milestoneId =>_display_(Seq[Any](format.raw/*107.53*/("""
    """),_display_(/*108.6*/milestones/*108.16*/.collect/*108.24*/ { case (milestone, openCount, closeCount) if(milestone.milestoneId == milestoneId) =>_display_(Seq[Any](format.raw/*108.110*/("""
      """),_display_(/*109.8*/gitbucket/*109.17*/.core.issues.milestones.html.progress(openCount + closeCount, closeCount)),format.raw/*109.90*/("""
    """)))}),format.raw/*110.6*/("""
  """)))}),format.raw/*111.4*/("""
"""),format.raw/*112.1*/("""</div>
<span id="label-milestone">
  """),_display_(/*114.4*/issue/*114.9*/.flatMap(_.milestoneId).map/*114.36*/ { milestoneId =>_display_(Seq[Any](format.raw/*114.53*/("""
    """),_display_(/*115.6*/milestones/*115.16*/.collect/*115.24*/ { case (milestone, _, _) if(milestone.milestoneId == milestoneId) =>_display_(Seq[Any](format.raw/*115.93*/("""
      """),format.raw/*116.7*/("""<a class="strong small username" href=""""),_display_(/*116.47*/helpers/*116.54*/.url(repository)),format.raw/*116.70*/("""/issues?milestone="""),_display_(/*116.89*/helpers/*116.96*/.urlEncode(milestone.title)),format.raw/*116.123*/("""&state=open">"""),_display_(/*116.137*/milestone/*116.146*/.title),format.raw/*116.152*/("""</a>
    """)))}),format.raw/*117.6*/("""
  """)))}/*118.4*/.getOrElse/*118.14*/ {_display_(Seq[Any](format.raw/*118.16*/("""
    """),format.raw/*119.5*/("""<span class="muted small">No milestone</span>
  """)))}),format.raw/*120.4*/("""
"""),format.raw/*121.1*/("""</span>
"""),_display_(if(issue.isEmpty)/*122.19*/{_display_(Seq[Any](format.raw/*122.20*/("""
  """),format.raw/*123.3*/("""<input type="hidden" name="milestoneId" value=""/>
""")))} else {null} ),format.raw/*124.2*/("""
"""),format.raw/*125.1*/("""<hr/>
<div style="margin-bottom: 14px;">
  <span class="muted small strong">Assignee</span>
  """),_display_(if(isManageable)/*128.20*/{_display_(Seq[Any](format.raw/*128.21*/("""
    """),format.raw/*129.5*/("""<div class="pull-right">
      """),_display_(/*130.8*/gitbucket/*130.17*/.core.helper.html.dropdown("Edit", right = true, filter = ("assignee", "Filter Assignee"))/*130.107*/ {_display_(Seq[Any](format.raw/*130.109*/("""
        """),_display_(/*131.10*/collaborators/*131.23*/.map/*131.27*/ { collaborator =>_display_(Seq[Any](format.raw/*131.45*/("""
          """),format.raw/*132.11*/("""<li>
            <a href="javascript:void(0);" class="toggle-assign" data-name=""""),_display_(/*133.77*/collaborator),format.raw/*133.89*/("""">
              """),_display_(/*134.16*/gitbucket/*134.25*/.core.helper.html.checkicon(issueAssignees.exists(_.assigneeUserName == collaborator))),_display_(/*134.112*/helpers/*134.119*/.avatar(collaborator, 20)),format.raw/*134.144*/(""" """),_display_(/*134.146*/collaborator),format.raw/*134.158*/("""
            """),format.raw/*135.13*/("""</a>
          </li>
        """)))}),format.raw/*137.10*/("""
      """)))}),format.raw/*138.8*/("""
    """),format.raw/*139.5*/("""</div>
  """)))} else {null} ),format.raw/*140.4*/("""
"""),format.raw/*141.1*/("""</div>
<span id="label-assigned">
  """),_display_(/*143.4*/issueAssignees/*143.18*/.map/*143.22*/ { assignee =>_display_(Seq[Any](format.raw/*143.36*/("""
    """),format.raw/*144.5*/("""<div>"""),_display_(/*144.11*/helpers/*144.18*/.avatarLink(assignee.assigneeUserName, 20)),format.raw/*144.60*/(""" """),_display_(/*144.62*/helpers/*144.69*/.user(assignee.assigneeUserName, styleClass="username strong small")),format.raw/*144.137*/("""</div>
  """)))}),format.raw/*145.4*/("""
  """),_display_(if(issueAssignees.isEmpty)/*146.30*/ {_display_(Seq[Any](format.raw/*146.32*/("""
    """),format.raw/*147.5*/("""<span class="muted small">No one assigned</span>
  """)))} else {null} ),format.raw/*148.4*/("""
"""),format.raw/*149.1*/("""</span>
"""),_display_(if(issue.isEmpty)/*150.19*/{_display_(Seq[Any](format.raw/*150.20*/("""
  """),format.raw/*151.3*/("""<input type="hidden" name="assigneeUserNames" value=""/>
""")))} else {null} ),format.raw/*152.2*/("""

"""),_display_(/*154.2*/customFields/*154.14*/.map/*154.18*/ { case (field, value) =>_display_(Seq[Any](format.raw/*154.43*/("""
  """),format.raw/*155.3*/("""<hr/>
  <div style="margin-bottom: 14px;">
    <span class="muted small strong">"""),_display_(/*157.39*/field/*157.44*/.fieldName),format.raw/*157.54*/("""</span>
    <div class="pull-right">
      """),_display_(/*159.8*/gitbucket/*159.17*/.core.model.CustomFieldBehavior(field.fieldType).map/*159.69*/ { behavior =>_display_(Seq[Any](format.raw/*159.83*/("""
        """),_display_(if(issue.nonEmpty)/*160.28*/ {_display_(Seq[Any](format.raw/*160.30*/("""
          """),_display_(/*161.12*/Html(behavior.fieldHtml(repository, issue.get.issueId, field.fieldId, field.fieldName, field.constraints, value.map(_.value).getOrElse(""), isManageable))),format.raw/*161.166*/("""
        """)))} else {null} ),format.raw/*162.10*/("""
        """),_display_(if(issue.isEmpty)/*163.27*/ {_display_(Seq[Any](format.raw/*163.29*/("""
          """),_display_(/*164.12*/Html(behavior.createHtml(repository, field.fieldId, field.fieldName, field.constraints))),format.raw/*164.100*/("""
        """)))} else {null} ),format.raw/*165.10*/("""
      """)))}),format.raw/*166.8*/("""
    """),format.raw/*167.5*/("""</div>
  </div>
  <span id="custom-field-"""),_display_(/*169.27*/field/*169.32*/.fieldId),format.raw/*169.40*/("""-error" class="error custom-field-error"></span>
""")))}),format.raw/*170.2*/("""

"""),_display_(/*172.2*/issue/*172.7*/.map/*172.11*/ { issue =>_display_(Seq[Any](format.raw/*172.22*/("""
  """),_display_(/*173.4*/gitbucket/*173.13*/.core.plugin.PluginRegistry().getIssueSidebars.map/*173.63*/ { sidebarComponent =>_display_(Seq[Any](format.raw/*173.85*/("""
    """),_display_(/*174.6*/sidebarComponent(issue, repository, context)),format.raw/*174.50*/("""
  """)))}),format.raw/*175.4*/("""
  """),format.raw/*176.3*/("""<hr/>
  <div style="margin-bottom: 14px;">
    """),_display_(/*178.6*/defining((issue.openedUserName :: comments.map(_.commentedUserName)).distinct)/*178.84*/{ participants =>_display_(Seq[Any](format.raw/*178.101*/("""
      """),format.raw/*179.7*/("""<div class="muted small strong">"""),_display_(/*179.40*/participants/*179.52*/.size),format.raw/*179.57*/(""" """),_display_(/*179.59*/helpers/*179.66*/.plural(participants.size, "participant")),format.raw/*179.107*/("""</div>
    """)))}),format.raw/*180.6*/("""
  """),format.raw/*181.3*/("""</div>
  """),_display_(/*182.4*/defining((issue.openedUserName :: comments.map(_.commentedUserName)).distinct)/*182.82*/{ participants =>_display_(Seq[Any](format.raw/*182.99*/("""
    """),_display_(/*183.6*/participants/*183.18*/.map/*183.22*/ { participant =>_display_(Seq[Any](format.raw/*183.39*/("""
      """),_display_(/*184.8*/helpers/*184.15*/.avatarLink(participant, 20, tooltip = true)),format.raw/*184.59*/("""
    """)))}),format.raw/*185.6*/("""
  """)))}),format.raw/*186.4*/("""
""")))}),format.raw/*187.2*/("""
"""),format.raw/*188.1*/("""<script>
$(function()"""),format.raw/*189.13*/("""{"""),format.raw/*189.14*/("""
"""),_display_(/*190.2*/issue/*190.7*/.map/*190.11*/ { issue =>_display_(Seq[Any](format.raw/*190.22*/("""
  """),format.raw/*191.3*/("""$('a.toggle-label').click(function()"""),format.raw/*191.39*/("""{"""),format.raw/*191.40*/("""
    """),format.raw/*192.5*/("""const path = switchToggleOptions($(this));
    $.post('"""),_display_(/*193.14*/helpers/*193.21*/.url(repository)),format.raw/*193.37*/("""/issues/"""),_display_(/*193.46*/issue/*193.51*/.issueId),format.raw/*193.59*/("""/label/' + path,
      """),format.raw/*194.7*/("""{"""),format.raw/*194.8*/(""" """),format.raw/*194.9*/("""labelId : $(this).data('label-id') """),format.raw/*194.44*/("""}"""),format.raw/*194.45*/(""",
      function(data)"""),format.raw/*195.21*/("""{"""),format.raw/*195.22*/("""
        """),format.raw/*196.9*/("""$('ul.label-list').empty().html(data);
      """),format.raw/*197.7*/("""}"""),format.raw/*197.8*/("""
    """),format.raw/*198.5*/(""");
    return false;
  """),format.raw/*200.3*/("""}"""),format.raw/*200.4*/(""");

  $('a.milestone').click(function()"""),format.raw/*202.36*/("""{"""),format.raw/*202.37*/("""
    """),format.raw/*203.5*/("""const title = $(this).data('title');
    const milestoneId = $(this).data('id');
    $.post('"""),_display_(/*205.14*/helpers/*205.21*/.url(repository)),format.raw/*205.37*/("""/issues/"""),_display_(/*205.46*/issue/*205.51*/.issueId),format.raw/*205.59*/("""/milestone',
      """),format.raw/*206.7*/("""{"""),format.raw/*206.8*/(""" """),format.raw/*206.9*/("""milestoneId: milestoneId """),format.raw/*206.34*/("""}"""),format.raw/*206.35*/(""",
      function(data)"""),format.raw/*207.21*/("""{"""),format.raw/*207.22*/("""
        """),format.raw/*208.9*/("""displayMilestone(title, milestoneId, data);
      """),format.raw/*209.7*/("""}"""),format.raw/*209.8*/("""
    """),format.raw/*210.5*/(""");
  """),format.raw/*211.3*/("""}"""),format.raw/*211.4*/(""");

  $('a.priority').click(function()"""),format.raw/*213.35*/("""{"""),format.raw/*213.36*/("""
    """),format.raw/*214.5*/("""const priorityName = $(this).data('name');
    const priorityId = $(this).data('id');
    const description = $(this).attr('title');
    const color = $(this).data('color');
    const fontColor = $(this).data('font-color');
    $.post('"""),_display_(/*219.14*/helpers/*219.21*/.url(repository)),format.raw/*219.37*/("""/issues/"""),_display_(/*219.46*/issue/*219.51*/.issueId),format.raw/*219.59*/("""/priority',
      """),format.raw/*220.7*/("""{"""),format.raw/*220.8*/(""" """),format.raw/*220.9*/("""priorityId: priorityId """),format.raw/*220.32*/("""}"""),format.raw/*220.33*/(""",
      function(data)"""),format.raw/*221.21*/("""{"""),format.raw/*221.22*/("""
        """),format.raw/*222.9*/("""displayPriority(priorityName, priorityId, description, color, fontColor);
      """),format.raw/*223.7*/("""}"""),format.raw/*223.8*/("""
    """),format.raw/*224.5*/(""");
  """),format.raw/*225.3*/("""}"""),format.raw/*225.4*/(""");

  $('a.toggle-assign').click(function()"""),format.raw/*227.40*/("""{"""),format.raw/*227.41*/("""
    """),format.raw/*228.5*/("""const path = switchToggleOptions($(this));
    $.post('"""),_display_(/*229.14*/helpers/*229.21*/.url(repository)),format.raw/*229.37*/("""/issues/"""),_display_(/*229.46*/issue/*229.51*/.issueId),format.raw/*229.59*/("""/assignee/' + path,
      """),format.raw/*230.7*/("""{"""),format.raw/*230.8*/(""" """),format.raw/*230.9*/("""assigneeUserName : $(this).data('name') """),format.raw/*230.49*/("""}"""),format.raw/*230.50*/(""",
      function(data)"""),format.raw/*231.21*/("""{"""),format.raw/*231.22*/("""
        """),format.raw/*232.9*/("""const assignees = Array();
        $('a.toggle-assign').each(function(i, e)"""),format.raw/*233.49*/("""{"""),format.raw/*233.50*/("""
          """),format.raw/*234.11*/("""if($(e).children('i').hasClass('octicon-check') == true)"""),format.raw/*234.67*/("""{"""),format.raw/*234.68*/("""
            """),format.raw/*235.13*/("""assignees.push($(e).text().trim());
          """),format.raw/*236.11*/("""}"""),format.raw/*236.12*/("""
        """),format.raw/*237.9*/("""}"""),format.raw/*237.10*/(""");
        displayAssignee(assignees);
      """),format.raw/*239.7*/("""}"""),format.raw/*239.8*/("""
    """),format.raw/*240.5*/(""");
    return false;
  """),format.raw/*242.3*/("""}"""),format.raw/*242.4*/(""");
""")))}/*243.2*/.getOrElse/*243.12*/ {_display_(Seq[Any](format.raw/*243.14*/("""
  """),format.raw/*244.3*/("""$('a.toggle-label').click(function()"""),format.raw/*244.39*/("""{"""),format.raw/*244.40*/("""
    """),format.raw/*245.5*/("""switchToggleOptions($(this));
    const labelNames = Array();
    $('a.toggle-label').each(function(i, e)"""),format.raw/*247.44*/("""{"""),format.raw/*247.45*/("""
      """),format.raw/*248.7*/("""if($(e).children('i').hasClass('octicon-check') == true)"""),format.raw/*248.63*/("""{"""),format.raw/*248.64*/("""
        """),format.raw/*249.9*/("""labelNames.push($(e).text().trim());
      """),format.raw/*250.7*/("""}"""),format.raw/*250.8*/("""
    """),format.raw/*251.5*/("""}"""),format.raw/*251.6*/(""");
    $('input[name=labelNames]').val(labelNames.join(','));

    $.post('"""),_display_(/*254.14*/helpers/*254.21*/.url(repository)),format.raw/*254.37*/("""/issues/new/label',
      """),format.raw/*255.7*/("""{"""),format.raw/*255.8*/(""" """),format.raw/*255.9*/("""labelNames : labelNames.join(',') """),format.raw/*255.43*/("""}"""),format.raw/*255.44*/(""",
      function(data)"""),format.raw/*256.21*/("""{"""),format.raw/*256.22*/("""
        """),format.raw/*257.9*/("""$('ul.label-list').empty().html(data);
      """),format.raw/*258.7*/("""}"""),format.raw/*258.8*/("""
    """),format.raw/*259.5*/(""");
  """),format.raw/*260.3*/("""}"""),format.raw/*260.4*/(""");

  $('a.milestone').click(function()"""),format.raw/*262.36*/("""{"""),format.raw/*262.37*/("""
    """),format.raw/*263.5*/("""const title = $(this).data('title');
    const milestoneId = $(this).data('id');
    displayMilestone(title, milestoneId);
    $('input[name=milestoneId]').val(milestoneId);
  """),format.raw/*267.3*/("""}"""),format.raw/*267.4*/(""");

  $('a.priority').click(function()"""),format.raw/*269.35*/("""{"""),format.raw/*269.36*/("""
    """),format.raw/*270.5*/("""const priorityName = $(this).data('name');
    const priorityId = $(this).data('id');
    const description = $(this).attr('title');
    const color = $(this).data('color');
    const fontColor = $(this).data('font-color');
    displayPriority(priorityName, priorityId, description, color, fontColor);
    $('input[name=priorityId]').val(priorityId);
  """),format.raw/*277.3*/("""}"""),format.raw/*277.4*/(""");

  $('a.toggle-assign').click(function()"""),format.raw/*279.40*/("""{"""),format.raw/*279.41*/("""
    """),format.raw/*280.5*/("""switchToggleOptions($(this));
    const assignees = Array();
    $('a.toggle-assign').each(function(i, e)"""),format.raw/*282.45*/("""{"""),format.raw/*282.46*/("""
      """),format.raw/*283.7*/("""if($(e).children('i').hasClass('octicon-check') == true)"""),format.raw/*283.63*/("""{"""),format.raw/*283.64*/("""
        """),format.raw/*284.9*/("""assignees.push($(e).text().trim());
      """),format.raw/*285.7*/("""}"""),format.raw/*285.8*/("""
    """),format.raw/*286.5*/("""}"""),format.raw/*286.6*/(""");
    $('input[name=assigneeUserNames]').val(assignees.join(','));
    displayAssignee(assignees);
  """),format.raw/*289.3*/("""}"""),format.raw/*289.4*/(""");
""")))}),format.raw/*290.2*/("""

  """),format.raw/*292.3*/("""function switchToggleOptions($this)"""),format.raw/*292.38*/("""{"""),format.raw/*292.39*/("""
    """),format.raw/*293.5*/("""const i = $this.children('i');
    if(i.hasClass('octicon-check'))"""),format.raw/*294.36*/("""{"""),format.raw/*294.37*/("""
      """),format.raw/*295.7*/("""i.removeClass('octicon-check');
      return 'delete';
    """),format.raw/*297.5*/("""}"""),format.raw/*297.6*/(""" """),format.raw/*297.7*/("""else """),format.raw/*297.12*/("""{"""),format.raw/*297.13*/("""
      """),format.raw/*298.7*/("""i.addClass('octicon-check');
      return 'new';
    """),format.raw/*300.5*/("""}"""),format.raw/*300.6*/("""
  """),format.raw/*301.3*/("""}"""),format.raw/*301.4*/("""

  """),format.raw/*303.3*/("""function displayMilestone(title, milestoneId, progress)"""),format.raw/*303.58*/("""{"""),format.raw/*303.59*/("""
    """),format.raw/*304.5*/("""$('a.milestone i.octicon-check').removeClass('octicon-check');
    if(milestoneId == '')"""),format.raw/*305.26*/("""{"""),format.raw/*305.27*/("""
      """),format.raw/*306.7*/("""$('#label-milestone').html($('<span class="muted small">').text('No milestone'));
      $('#milestone-progress-area').empty();
    """),format.raw/*308.5*/("""}"""),format.raw/*308.6*/(""" """),format.raw/*308.7*/("""else """),format.raw/*308.12*/("""{"""),format.raw/*308.13*/("""
      """),format.raw/*309.7*/("""$('#label-milestone').html($('<a class="strong small username">').text(title)
        .attr('href', '"""),_display_(/*310.25*/helpers/*310.32*/.url(repository)),format.raw/*310.48*/("""/issues?milestone=' + encodeURIComponent(title) + '&state=open'));
      if(progress)"""),format.raw/*311.19*/("""{"""),format.raw/*311.20*/("""
        """),format.raw/*312.9*/("""$('#milestone-progress-area').html(progress);
      """),format.raw/*313.7*/("""}"""),format.raw/*313.8*/("""
      """),format.raw/*314.7*/("""$('a.milestone[data-id=' + milestoneId + '] i').addClass('octicon-check');
    """),format.raw/*315.5*/("""}"""),format.raw/*315.6*/("""
  """),format.raw/*316.3*/("""}"""),format.raw/*316.4*/("""

  """),format.raw/*318.3*/("""function displayPriority(priorityName, priorityId, description, color, fontColor)"""),format.raw/*318.84*/("""{"""),format.raw/*318.85*/("""
    """),format.raw/*319.5*/("""$('a.priority i.octicon-check').removeClass('octicon-check');
    if(priorityId == '')"""),format.raw/*320.25*/("""{"""),format.raw/*320.26*/("""
      """),format.raw/*321.7*/("""$('#label-priority').html($('<span class="muted small">').text('No priority'));
    """),format.raw/*322.5*/("""}"""),format.raw/*322.6*/(""" """),format.raw/*322.7*/("""else """),format.raw/*322.12*/("""{"""),format.raw/*322.13*/("""
      """),format.raw/*323.7*/("""$('#label-priority').html($('<a class="issue-priority">').text(priorityName)
        .attr('href', '"""),_display_(/*324.25*/helpers/*324.32*/.url(repository)),format.raw/*324.48*/("""/issues?priority=' + encodeURIComponent(priorityName) + '&state=open')
        .attr('title', description)
        .css("""),format.raw/*326.14*/("""{"""),format.raw/*326.15*/("""
          """),format.raw/*327.11*/(""""background-color": color,
          "color": fontColor
        """),format.raw/*329.9*/("""}"""),format.raw/*329.10*/("""));

      $('a.priority[data-id=' + priorityId + '] i').addClass('octicon-check');
    """),format.raw/*332.5*/("""}"""),format.raw/*332.6*/("""
  """),format.raw/*333.3*/("""}"""),format.raw/*333.4*/("""

  """),format.raw/*335.3*/("""function displayAssignee(assignees)"""),format.raw/*335.38*/("""{"""),format.raw/*335.39*/("""
    """),format.raw/*336.5*/("""$('a.assign i.octicon-check').removeClass('octicon-check');
    if(assignees.length == 0)"""),format.raw/*337.30*/("""{"""),format.raw/*337.31*/("""
      """),format.raw/*338.7*/("""$('#label-assigned').html($('<span class="muted small">').text('No one assigned'));
    """),format.raw/*339.5*/("""}"""),format.raw/*339.6*/(""" """),format.raw/*339.7*/("""else """),format.raw/*339.12*/("""{"""),format.raw/*339.13*/("""
      """),format.raw/*340.7*/("""$('#label-assigned').empty();
      for (const userName of assignees) """),format.raw/*341.41*/("""{"""),format.raw/*341.42*/("""
        """),format.raw/*342.9*/("""$('#label-assigned').append($('<div>').append(
            $('a.toggle-assign').parent().find("img.avatar-mini[alt='@" + userName + "']").clone(false),
            ' ',
            $('<a class="username strong small">').attr('href', '"""),_display_(/*345.67*/context/*345.74*/.path),format.raw/*345.79*/("""/' + userName).text(userName)));
      """),format.raw/*346.7*/("""}"""),format.raw/*346.8*/("""
    """),format.raw/*347.5*/("""}"""),format.raw/*347.6*/("""
  """),format.raw/*348.3*/("""}"""),format.raw/*348.4*/("""
"""),format.raw/*349.1*/("""}"""),format.raw/*349.2*/(""");
</script>
"""))
      }
    }
  }

  def render(issue:Option[gitbucket.core.model.Issue],comments:List[gitbucket.core.model.Comment],issueLabels:List[gitbucket.core.model.Label],issueAssignees:List[gitbucket.core.model.IssueAssignee],collaborators:List[String],milestones:List[(gitbucket.core.model.Milestone, Int, Int)],priorities:List[gitbucket.core.model.Priority],defaultPriority:Option[gitbucket.core.model.Priority],labels:List[gitbucket.core.model.Label],customFields:List[(gitbucket.core.model.CustomField, Option[gitbucket.core.model.IssueCustomField])],isManageable:Boolean,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(issue,comments,issueLabels,issueAssignees,collaborators,milestones,priorities,defaultPriority,labels,customFields,isManageable,repository)(context)

  def f:((Option[gitbucket.core.model.Issue],List[gitbucket.core.model.Comment],List[gitbucket.core.model.Label],List[gitbucket.core.model.IssueAssignee],List[String],List[(gitbucket.core.model.Milestone, Int, Int)],List[gitbucket.core.model.Priority],Option[gitbucket.core.model.Priority],List[gitbucket.core.model.Label],List[(gitbucket.core.model.CustomField, Option[gitbucket.core.model.IssueCustomField])],Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (issue,comments,issueLabels,issueAssignees,collaborators,milestones,priorities,defaultPriority,labels,customFields,isManageable,repository) => (context) => apply(issue,comments,issueLabels,issueAssignees,collaborators,milestones,priorities,defaultPriority,labels,customFields,isManageable,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/issues/issueinfo.scala.html
                  HASH: dc1baf73f45bcc5758a18f248069fb83e4eecada
                  MATRIX: 285->1|1142->58|1918->762|1982->797|2112->900|2151->901|2183->906|2241->938|2259->947|2355->1033|2396->1035|2433->1045|2448->1051|2461->1055|2510->1066|2549->1077|2642->1143|2656->1148|2685->1156|2730->1174|2748->1183|2845->1258|2888->1273|2962->1320|2976->1325|3003->1331|3062->1363|3076->1368|3107->1378|3148->1391|3209->1421|3247->1429|3299->1454|3338->1455|3374->1464|3474->1521|3506->1526|3559->1536|3587->1537|3673->1597|3691->1606|3752->1646|3780->1647|3925->1765|3964->1766|3996->1771|4054->1803|4072->1812|4172->1902|4213->1904|4249->1913|4405->2042|4424->2052|4437->2056|4489->2070|4528->2081|4629->2155|4646->2163|4678->2174|4720->2188|4738->2196|4773->2209|4817->2225|4835->2233|4863->2239|4912->2260|4930->2268|4962->2278|5025->2313|5066->2315|5096->2316|5132->2324|5150->2332|5188->2348|5236->2351|5280->2368|5298->2377|5472->2529|5515->2544|5589->2591|5606->2599|5633->2605|5692->2637|5709->2645|5743->2658|5784->2671|5845->2701|5883->2709|5915->2714|5968->2724|5996->2725|6059->2762|6072->2767|6149->2835|6203->2851|6235->2857|6254->2867|6271->2875|6282->2878|6345->2932|6385->2934|6419->2941|6499->2994|6516->3002|6543->3008|6581->3019|6598->3027|6630->3037|6668->3047|6685->3054|6723->3070|6769->3088|6786->3095|6841->3128|6915->3174|6956->3176|6986->3177|7022->3185|7040->3193|7078->3209|7126->3212|7156->3214|7174->3222|7209->3235|7250->3246|7272->3250|7291->3260|7331->3262|7363->3267|7441->3315|7469->3316|7522->3342|7561->3343|7591->3346|7665->3393|7689->3408|7759->3456|7807->3461|7835->3462|7975->3575|8014->3576|8046->3581|8104->3613|8122->3622|8224->3714|8265->3716|8301->3725|8464->3861|8483->3871|8528->3907|8594->3935|8633->3946|8735->4021|8753->4030|8786->4042|8829->4057|8848->4066|8876->4072|8921->4090|8935->4095|8948->4099|8997->4110|9042->4128|9060->4137|9159->4214|9206->4230|9249->4246|9267->4255|9294->4261|9337->4276|9429->4341|9447->4350|9468->4362|9519->4375|9593->4422|9632->4423|9681->4444|9827->4563|9843->4570|9878->4584|9928->4617|9967->4618|10016->4639|10071->4667|10087->4674|10122->4688|10180->4715|10217->4733|10236->4743|10276->4745|10323->4764|10410->4820|10453->4835|10534->4884|10573->4892|10606->4897|10660->4907|10689->4908|10761->4953|10775->4958|10812->4985|10868->5002|10901->5008|10921->5018|10939->5026|11065->5112|11100->5120|11119->5129|11214->5202|11251->5208|11286->5212|11315->5213|11380->5251|11394->5256|11431->5283|11487->5300|11520->5306|11540->5316|11558->5324|11666->5393|11701->5400|11769->5440|11786->5447|11824->5463|11871->5482|11888->5489|11938->5516|11981->5530|12001->5539|12030->5545|12071->5555|12094->5559|12114->5569|12155->5571|12188->5576|12268->5625|12297->5626|12351->5652|12391->5653|12422->5656|12518->5708|12547->5709|12686->5820|12726->5821|12759->5826|12818->5858|12837->5867|12938->5957|12980->5959|13018->5969|13041->5982|13055->5986|13112->6004|13152->6015|13261->6096|13295->6108|13341->6126|13360->6135|13469->6222|13487->6229|13535->6254|13566->6256|13601->6268|13643->6281|13705->6311|13744->6319|13777->6324|13831->6334|13860->6335|13924->6372|13948->6386|13962->6390|14015->6404|14048->6409|14082->6415|14099->6422|14163->6464|14193->6466|14210->6473|14301->6541|14342->6551|14400->6581|14441->6583|14474->6588|14570->6640|14599->6641|14653->6667|14693->6668|14724->6671|14826->6729|14856->6732|14878->6744|14892->6748|14956->6773|14987->6776|15096->6857|15111->6862|15143->6872|15214->6916|15233->6925|15295->6977|15348->6991|15404->7019|15445->7021|15485->7033|15662->7187|15717->7197|15772->7224|15813->7226|15853->7238|15964->7326|16019->7336|16058->7344|16091->7349|16161->7391|16176->7396|16206->7404|16287->7454|16317->7457|16331->7462|16345->7466|16395->7477|16426->7481|16445->7490|16505->7540|16566->7562|16599->7568|16665->7612|16700->7616|16731->7619|16806->7667|16894->7745|16951->7762|16986->7769|17047->7802|17069->7814|17096->7819|17126->7821|17143->7828|17207->7869|17250->7881|17281->7884|17318->7894|17406->7972|17462->7989|17495->7995|17517->8007|17531->8011|17587->8028|17622->8036|17639->8043|17705->8087|17742->8093|17777->8097|17810->8099|17839->8100|17889->8121|17919->8122|17948->8124|17962->8129|17976->8133|18026->8144|18057->8147|18122->8183|18152->8184|18185->8189|18269->8245|18286->8252|18324->8268|18361->8277|18376->8282|18406->8290|18457->8313|18486->8314|18515->8315|18579->8350|18609->8351|18660->8373|18690->8374|18727->8383|18800->8428|18829->8429|18862->8434|18913->8457|18942->8458|19010->8497|19040->8498|19073->8503|19195->8597|19212->8604|19250->8620|19287->8629|19302->8634|19332->8642|19379->8661|19408->8662|19437->8663|19491->8688|19521->8689|19572->8711|19602->8712|19639->8721|19717->8771|19746->8772|19779->8777|19812->8782|19841->8783|19908->8821|19938->8822|19971->8827|20236->9064|20253->9071|20291->9087|20328->9096|20343->9101|20373->9109|20419->9127|20448->9128|20477->9129|20529->9152|20559->9153|20610->9175|20640->9176|20677->9185|20785->9265|20814->9266|20847->9271|20880->9276|20909->9277|20981->9320|21011->9321|21044->9326|21128->9382|21145->9389|21183->9405|21220->9414|21235->9419|21265->9427|21319->9453|21348->9454|21377->9455|21446->9495|21476->9496|21527->9518|21557->9519|21594->9528|21698->9603|21728->9604|21768->9615|21853->9671|21883->9672|21925->9685|22000->9731|22030->9732|22067->9741|22097->9742|22170->9787|22199->9788|22232->9793|22283->9816|22312->9817|22335->9821|22355->9831|22396->9833|22427->9836|22492->9872|22522->9873|22555->9878|22689->9983|22719->9984|22754->9991|22839->10047|22869->10048|22906->10057|22977->10100|23006->10101|23039->10106|23068->10107|23172->10183|23189->10190|23227->10206|23281->10232|23310->10233|23339->10234|23402->10268|23432->10269|23483->10291|23513->10292|23550->10301|23623->10346|23652->10347|23685->10352|23718->10357|23747->10358|23815->10397|23845->10398|23878->10403|24082->10579|24111->10580|24178->10618|24208->10619|24241->10624|24622->10977|24651->10978|24723->11021|24753->11022|24786->11027|24920->11132|24950->11133|24985->11140|25070->11196|25100->11197|25137->11206|25207->11248|25236->11249|25269->11254|25298->11255|25428->11357|25457->11358|25492->11362|25524->11366|25588->11401|25618->11402|25651->11407|25746->11473|25776->11474|25811->11481|25898->11540|25927->11541|25956->11542|25990->11547|26020->11548|26055->11555|26136->11608|26165->11609|26196->11612|26225->11613|26257->11617|26341->11672|26371->11673|26404->11678|26521->11766|26551->11767|26586->11774|26745->11905|26774->11906|26803->11907|26837->11912|26867->11913|26902->11920|27032->12022|27049->12029|27087->12045|27201->12130|27231->12131|27268->12140|27348->12192|27377->12193|27412->12200|27519->12279|27548->12280|27579->12283|27608->12284|27640->12288|27750->12369|27780->12370|27813->12375|27928->12461|27958->12462|27993->12469|28105->12553|28134->12554|28163->12555|28197->12560|28227->12561|28262->12568|28391->12669|28408->12676|28446->12692|28595->12812|28625->12813|28665->12824|28757->12888|28787->12889|28903->12977|28932->12978|28963->12981|28992->12982|29024->12986|29088->13021|29118->13022|29151->13027|29269->13116|29299->13117|29334->13124|29450->13212|29479->13213|29508->13214|29542->13219|29572->13220|29607->13227|29706->13297|29736->13298|29773->13307|30036->13543|30053->13550|30080->13555|30147->13594|30176->13595|30209->13600|30238->13601|30269->13604|30298->13605|30327->13606|30356->13607
                  LINES: 10->1|15->2|29->14|32->15|34->17|34->17|35->18|36->19|36->19|36->19|36->19|37->20|37->20|37->20|37->20|38->21|39->22|39->22|39->22|40->23|40->23|40->23|41->24|41->24|41->24|41->24|42->25|42->25|42->25|43->26|45->28|46->29|47->30|47->30|48->31|49->32|50->33|51->34|52->35|54->37|54->37|54->37|55->38|60->43|60->43|61->44|62->45|62->45|62->45|62->45|63->46|64->47|64->47|64->47|64->47|65->48|66->49|66->49|66->49|66->49|66->49|66->49|66->49|66->49|66->49|66->49|66->49|66->49|66->49|66->49|66->49|66->49|66->49|66->49|66->49|67->50|67->50|67->50|68->51|68->51|68->51|68->51|69->52|69->52|69->52|70->53|72->55|73->56|74->57|75->58|76->59|78->61|78->61|78->61|78->61|79->62|79->62|79->62|79->62|79->62|79->62|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|81->64|82->65|82->65|82->65|83->66|84->67|85->68|86->69|86->69|87->70|87->70|87->70|87->70|88->71|89->72|93->76|93->76|94->77|95->78|95->78|95->78|95->78|96->79|97->80|97->80|97->80|97->80|98->81|99->82|99->82|99->82|99->82|99->82|99->82|100->83|100->83|100->83|100->83|101->84|101->84|101->84|102->85|103->86|103->86|103->86|104->87|105->88|105->88|105->88|105->88|106->89|106->89|107->90|108->91|108->91|108->91|109->92|109->92|110->93|110->93|110->93|110->93|111->94|112->95|112->95|112->95|113->96|114->97|115->98|118->101|119->102|120->103|121->104|122->105|124->107|124->107|124->107|124->107|125->108|125->108|125->108|125->108|126->109|126->109|126->109|127->110|128->111|129->112|131->114|131->114|131->114|131->114|132->115|132->115|132->115|132->115|133->116|133->116|133->116|133->116|133->116|133->116|133->116|133->116|133->116|133->116|134->117|135->118|135->118|135->118|136->119|137->120|138->121|139->122|139->122|140->123|141->124|142->125|145->128|145->128|146->129|147->130|147->130|147->130|147->130|148->131|148->131|148->131|148->131|149->132|150->133|150->133|151->134|151->134|151->134|151->134|151->134|151->134|151->134|152->135|154->137|155->138|156->139|157->140|158->141|160->143|160->143|160->143|160->143|161->144|161->144|161->144|161->144|161->144|161->144|161->144|162->145|163->146|163->146|164->147|165->148|166->149|167->150|167->150|168->151|169->152|171->154|171->154|171->154|171->154|172->155|174->157|174->157|174->157|176->159|176->159|176->159|176->159|177->160|177->160|178->161|178->161|179->162|180->163|180->163|181->164|181->164|182->165|183->166|184->167|186->169|186->169|186->169|187->170|189->172|189->172|189->172|189->172|190->173|190->173|190->173|190->173|191->174|191->174|192->175|193->176|195->178|195->178|195->178|196->179|196->179|196->179|196->179|196->179|196->179|196->179|197->180|198->181|199->182|199->182|199->182|200->183|200->183|200->183|200->183|201->184|201->184|201->184|202->185|203->186|204->187|205->188|206->189|206->189|207->190|207->190|207->190|207->190|208->191|208->191|208->191|209->192|210->193|210->193|210->193|210->193|210->193|210->193|211->194|211->194|211->194|211->194|211->194|212->195|212->195|213->196|214->197|214->197|215->198|217->200|217->200|219->202|219->202|220->203|222->205|222->205|222->205|222->205|222->205|222->205|223->206|223->206|223->206|223->206|223->206|224->207|224->207|225->208|226->209|226->209|227->210|228->211|228->211|230->213|230->213|231->214|236->219|236->219|236->219|236->219|236->219|236->219|237->220|237->220|237->220|237->220|237->220|238->221|238->221|239->222|240->223|240->223|241->224|242->225|242->225|244->227|244->227|245->228|246->229|246->229|246->229|246->229|246->229|246->229|247->230|247->230|247->230|247->230|247->230|248->231|248->231|249->232|250->233|250->233|251->234|251->234|251->234|252->235|253->236|253->236|254->237|254->237|256->239|256->239|257->240|259->242|259->242|260->243|260->243|260->243|261->244|261->244|261->244|262->245|264->247|264->247|265->248|265->248|265->248|266->249|267->250|267->250|268->251|268->251|271->254|271->254|271->254|272->255|272->255|272->255|272->255|272->255|273->256|273->256|274->257|275->258|275->258|276->259|277->260|277->260|279->262|279->262|280->263|284->267|284->267|286->269|286->269|287->270|294->277|294->277|296->279|296->279|297->280|299->282|299->282|300->283|300->283|300->283|301->284|302->285|302->285|303->286|303->286|306->289|306->289|307->290|309->292|309->292|309->292|310->293|311->294|311->294|312->295|314->297|314->297|314->297|314->297|314->297|315->298|317->300|317->300|318->301|318->301|320->303|320->303|320->303|321->304|322->305|322->305|323->306|325->308|325->308|325->308|325->308|325->308|326->309|327->310|327->310|327->310|328->311|328->311|329->312|330->313|330->313|331->314|332->315|332->315|333->316|333->316|335->318|335->318|335->318|336->319|337->320|337->320|338->321|339->322|339->322|339->322|339->322|339->322|340->323|341->324|341->324|341->324|343->326|343->326|344->327|346->329|346->329|349->332|349->332|350->333|350->333|352->335|352->335|352->335|353->336|354->337|354->337|355->338|356->339|356->339|356->339|356->339|356->339|357->340|358->341|358->341|359->342|362->345|362->345|362->345|363->346|363->346|364->347|364->347|365->348|365->348|366->349|366->349
                  -- GENERATED --
              */
          