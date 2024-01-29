
package gitbucket.core.issues.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object issue extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template14[gitbucket.core.model.Issue,List[gitbucket.core.model.IssueComment],List[gitbucket.core.model.Label],List[gitbucket.core.model.IssueAssignee],List[String],List[(gitbucket.core.model.Milestone, Int, Int)],List[gitbucket.core.model.Priority],List[gitbucket.core.model.Label],List[(gitbucket.core.model.CustomField, Option[gitbucket.core.model.IssueCustomField])],Boolean,Boolean,Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(issue: gitbucket.core.model.Issue,
  comments: List[gitbucket.core.model.IssueComment],
  issueLabels: List[gitbucket.core.model.Label],
  issueAssignees: List[gitbucket.core.model.IssueAssignee],
  collaborators: List[String],
  milestones: List[(gitbucket.core.model.Milestone, Int, Int)],
  priorities: List[gitbucket.core.model.Priority],
  labels: List[gitbucket.core.model.Label],
  customFields: List[(gitbucket.core.model.CustomField, Option[gitbucket.core.model.IssueCustomField])],
  isEditable: Boolean,
  isManageable: Boolean,
  isCommentManageable: Boolean,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*14.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*15.2*/gitbucket/*15.11*/.core.html.main(s"${issue.title} - Issue #${issue.issueId} - ${repository.owner}/${repository.name}", Some(repository))/*15.130*/{_display_(Seq[Any](format.raw/*15.131*/("""
  """),_display_(/*16.4*/gitbucket/*16.13*/.core.html.menu("issues", repository)/*16.50*/{_display_(Seq[Any](format.raw/*16.51*/("""
    """),format.raw/*17.5*/("""<div>
      <div class="show-title pull-right">
        """),_display_(if(isManageable || context.loginAccount.map(_.userName == issue.openedUserName).getOrElse(false))/*19.107*/{_display_(Seq[Any](format.raw/*19.108*/("""
          """),format.raw/*20.11*/("""<a class="btn btn-default" href="#" id="edit">Edit</a>
        """)))} else {null} ),format.raw/*21.10*/("""
        """),_display_(if(isEditable)/*22.24*/{_display_(Seq[Any](format.raw/*22.25*/("""
          """),format.raw/*23.11*/("""<a class="btn btn-success" href=""""),_display_(/*23.45*/helpers/*23.52*/.url(repository)),format.raw/*23.68*/("""/issues/new">New issue</a>
        """)))} else {null} ),format.raw/*24.10*/("""
      """),format.raw/*25.7*/("""</div>
      <div class="edit-title pull-right" style="display: none;">
        <a class="btn btn-success" href="#" id="update">Save</a>  <a class="btn btn-default" href="#" id="cancel">Cancel</a>
      </div>
      <h1 class="body-title">
        <span class="show-title">
          <span id="show-title">"""),_display_(/*31.34*/issue/*31.39*/.title),format.raw/*31.45*/("""</span>
          <span class="muted">#"""),_display_(/*32.33*/issue/*32.38*/.issueId),format.raw/*32.46*/("""</span>
        </span>
        <span class="edit-title" style="display: none;">
          <span id="error-edit-title" class="error"></span>
          <input type="text" class="form-control" style="width: 700px;" id="edit-title" value=""""),_display_(/*36.97*/issue/*36.102*/.title),format.raw/*36.108*/(""""/>
        </span>
      </h1>
    </div>
    <div style="margin-bottom: 15px">
      """),_display_(if(issue.closed)/*41.24*/ {_display_(Seq[Any](format.raw/*41.26*/("""
        """),format.raw/*42.9*/("""<span class="label label-important issue-status">Closed</span>
      """)))}else/*43.14*/{_display_(Seq[Any](format.raw/*43.15*/("""
        """),format.raw/*44.9*/("""<span class="label label-success issue-status">Open</span>
      """)))}),format.raw/*45.8*/("""
      """),format.raw/*46.7*/("""<span class="muted">
        """),_display_(/*47.10*/helpers/*47.17*/.user(issue.openedUserName, styleClass="username strong")),format.raw/*47.74*/(""" """),format.raw/*47.75*/("""opened this issue """),_display_(/*47.94*/gitbucket/*47.103*/.core.helper.html.datetimeago(issue.registeredDate)),format.raw/*47.154*/(""" """),format.raw/*47.155*/("""- """),_display_(/*47.158*/defining(
          comments.count( _.action.contains("comment") )
        )/*49.10*/{ count =>_display_(Seq[Any](format.raw/*49.20*/("""
          """),_display_(/*50.12*/count),format.raw/*50.17*/(""" """),_display_(/*50.19*/helpers/*50.26*/.plural(count, "comment")),format.raw/*50.51*/("""
        """)))}),format.raw/*51.10*/("""
      """),format.raw/*52.7*/("""</span>
    </div>
    <hr>
    <div style="margin-top: 15px;">
      <div class="col-md-9">
        """),_display_(/*57.10*/gitbucket/*57.19*/.core.issues.html.commentlist(Some(issue), comments, isCommentManageable, repository)),format.raw/*57.104*/("""
        """),_display_(/*58.10*/gitbucket/*58.19*/.core.issues.html.commentform(issue, true, isEditable, isManageable, repository)),format.raw/*58.99*/("""
      """),format.raw/*59.7*/("""</div>
      <div class="col-md-3">
        """),_display_(/*61.10*/gitbucket/*61.19*/.core.issues.html.issueinfo(
          issue = Some(issue),
          comments = comments,
          issueLabels = issueLabels,
          issueAssignees = issueAssignees,
          collaborators = collaborators,
          milestones = milestones,
          priorities = priorities,
          defaultPriority = None,
          labels = labels,
          customFields = customFields,
          isManageable = isManageable,
          repository = repository
        )),format.raw/*74.10*/("""
      """),format.raw/*75.7*/("""</div>
    </div>
  """)))}),format.raw/*77.4*/("""
""")))}),format.raw/*78.2*/("""
"""),format.raw/*79.1*/("""<script>
$(function()"""),format.raw/*80.13*/("""{"""),format.raw/*80.14*/("""
  """),format.raw/*81.3*/("""$('#edit').click(function()"""),format.raw/*81.30*/("""{"""),format.raw/*81.31*/("""
    """),format.raw/*82.5*/("""$('.edit-title').show();
    $('.show-title').hide();
    $('#edit-title').focus();
    return false;
  """),format.raw/*86.3*/("""}"""),format.raw/*86.4*/(""");

  $('#update').click(function()"""),format.raw/*88.32*/("""{"""),format.raw/*88.33*/("""
    """),format.raw/*89.5*/("""$(this).attr('disabled', 'disabled');
    $.ajax("""),format.raw/*90.12*/("""{"""),format.raw/*90.13*/("""
      """),format.raw/*91.7*/("""url: '"""),_display_(/*91.14*/helpers/*91.21*/.url(repository)),format.raw/*91.37*/("""/issues/edit_title/"""),_display_(/*91.57*/issue/*91.62*/.issueId),format.raw/*91.70*/("""',
      type: 'POST',
      data: """),format.raw/*93.13*/("""{"""),format.raw/*93.14*/("""
        """),format.raw/*94.9*/("""title   : $('#edit-title').val()
      """),format.raw/*95.7*/("""}"""),format.raw/*95.8*/("""
    """),format.raw/*96.5*/("""}"""),format.raw/*96.6*/(""").done(function(data)"""),format.raw/*96.27*/("""{"""),format.raw/*96.28*/("""
      """),format.raw/*97.7*/("""$('#show-title').empty().text(data.title);
      $('#cancel').click();
      $('#update').removeAttr('disabled');
    """),format.raw/*100.5*/("""}"""),format.raw/*100.6*/(""").fail(function(req)"""),format.raw/*100.26*/("""{"""),format.raw/*100.27*/("""
      """),format.raw/*101.7*/("""$('#update').removeAttr('disabled');
      $('#error-edit-title').text($.parseJSON(req.responseText).title);
    """),format.raw/*103.5*/("""}"""),format.raw/*103.6*/(""");
    return false;
  """),format.raw/*105.3*/("""}"""),format.raw/*105.4*/(""");

  $('#cancel').click(function()"""),format.raw/*107.32*/("""{"""),format.raw/*107.33*/("""
    """),format.raw/*108.5*/("""$('.edit-title').hide();
    $('.show-title').show();
    return false;
  """),format.raw/*111.3*/("""}"""),format.raw/*111.4*/(""");
"""),format.raw/*112.1*/("""}"""),format.raw/*112.2*/(""");
</script>
"""))
      }
    }
  }

  def render(issue:gitbucket.core.model.Issue,comments:List[gitbucket.core.model.IssueComment],issueLabels:List[gitbucket.core.model.Label],issueAssignees:List[gitbucket.core.model.IssueAssignee],collaborators:List[String],milestones:List[(gitbucket.core.model.Milestone, Int, Int)],priorities:List[gitbucket.core.model.Priority],labels:List[gitbucket.core.model.Label],customFields:List[(gitbucket.core.model.CustomField, Option[gitbucket.core.model.IssueCustomField])],isEditable:Boolean,isManageable:Boolean,isCommentManageable:Boolean,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(issue,comments,issueLabels,issueAssignees,collaborators,milestones,priorities,labels,customFields,isEditable,isManageable,isCommentManageable,repository)(context)

  def f:((gitbucket.core.model.Issue,List[gitbucket.core.model.IssueComment],List[gitbucket.core.model.Label],List[gitbucket.core.model.IssueAssignee],List[String],List[(gitbucket.core.model.Milestone, Int, Int)],List[gitbucket.core.model.Priority],List[gitbucket.core.model.Label],List[(gitbucket.core.model.CustomField, Option[gitbucket.core.model.IssueCustomField])],Boolean,Boolean,Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (issue,comments,issueLabels,issueAssignees,collaborators,milestones,priorities,labels,customFields,isEditable,isManageable,isCommentManageable,repository) => (context) => apply(issue,comments,issueLabels,issueAssignees,collaborators,milestones,priorities,labels,customFields,isEditable,isManageable,isCommentManageable,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/issues/issue.scala.html
                  HASH: 32d91421fd1b8cbf5802f30db1cff7372d63dbee
                  MATRIX: 1050->1|1820->699|1884->735|1902->744|2031->863|2071->864|2101->868|2119->877|2165->914|2204->915|2236->920|2418->1074|2458->1075|2497->1086|2605->1150|2656->1174|2695->1175|2734->1186|2795->1220|2811->1227|2848->1243|2928->1279|2962->1286|3296->1593|3310->1598|3337->1604|3404->1644|3418->1649|3447->1657|3711->1894|3726->1899|3754->1905|3885->2009|3925->2011|3961->2020|4054->2096|4093->2097|4129->2106|4225->2172|4259->2179|4316->2209|4332->2216|4410->2273|4439->2274|4485->2293|4504->2302|4577->2353|4607->2354|4638->2357|4723->2433|4771->2443|4810->2455|4836->2460|4865->2462|4881->2469|4927->2494|4968->2504|5002->2511|5131->2613|5149->2622|5256->2707|5293->2717|5311->2726|5412->2806|5446->2813|5518->2858|5536->2867|6021->3331|6055->3338|6106->3359|6138->3361|6166->3362|6215->3383|6244->3384|6274->3387|6329->3414|6358->3415|6390->3420|6521->3524|6549->3525|6612->3560|6641->3561|6673->3566|6750->3615|6779->3616|6813->3623|6847->3630|6863->3637|6900->3653|6947->3673|6961->3678|6990->3686|7053->3721|7082->3722|7118->3731|7184->3770|7212->3771|7244->3776|7272->3777|7321->3798|7350->3799|7384->3806|7530->3924|7559->3925|7608->3945|7638->3946|7673->3953|7814->4066|7843->4067|7894->4090|7923->4091|7987->4126|8017->4127|8050->4132|8152->4206|8181->4207|8212->4210|8241->4211
                  LINES: 14->1|29->14|32->15|32->15|32->15|32->15|33->16|33->16|33->16|33->16|34->17|36->19|36->19|37->20|38->21|39->22|39->22|40->23|40->23|40->23|40->23|41->24|42->25|48->31|48->31|48->31|49->32|49->32|49->32|53->36|53->36|53->36|58->41|58->41|59->42|60->43|60->43|61->44|62->45|63->46|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|66->49|66->49|67->50|67->50|67->50|67->50|67->50|68->51|69->52|74->57|74->57|74->57|75->58|75->58|75->58|76->59|78->61|78->61|91->74|92->75|94->77|95->78|96->79|97->80|97->80|98->81|98->81|98->81|99->82|103->86|103->86|105->88|105->88|106->89|107->90|107->90|108->91|108->91|108->91|108->91|108->91|108->91|108->91|110->93|110->93|111->94|112->95|112->95|113->96|113->96|113->96|113->96|114->97|117->100|117->100|117->100|117->100|118->101|120->103|120->103|122->105|122->105|124->107|124->107|125->108|128->111|128->111|129->112|129->112
                  -- GENERATED --
              */
          