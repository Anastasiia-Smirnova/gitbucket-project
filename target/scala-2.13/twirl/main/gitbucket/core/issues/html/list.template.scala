
package gitbucket.core.issues.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object list extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template14[String,List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],Int,List[String],List[gitbucket.core.model.Milestone],List[gitbucket.core.model.Priority],List[gitbucket.core.model.Label],Int,Int,gitbucket.core.service.IssuesService.IssueSearchCondition,gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(target: String,
  issues: List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],
  page: Int,
  collaborators: List[String],
  milestones: List[gitbucket.core.model.Milestone],
  priorities: List[gitbucket.core.model.Priority],
  labels: List[gitbucket.core.model.Label],
  openCount: Int,
  closedCount: Int,
  condition: gitbucket.core.service.IssuesService.IssueSearchCondition,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  isEditable: Boolean,
  isManageable: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*15.2*/import gitbucket.core.view.helpers


Seq[Any](format.raw/*14.1*/("""
"""),format.raw/*16.1*/("""
"""),_display_(/*17.2*/gitbucket/*17.11*/.core.html.main((if(target == "issues") "Issues" else "Pull requests") + s" - ${repository.owner}/${repository.name}", Some(repository))/*17.147*/{_display_(Seq[Any](format.raw/*17.148*/("""
  """),_display_(/*18.4*/gitbucket/*18.13*/.core.html.menu(target, repository)/*18.48*/{_display_(Seq[Any](format.raw/*18.49*/("""
    """),format.raw/*19.5*/("""<ul class="nav nav-pills pull-left" style="line-height: 14px; margin-bottom: 10px;">
      <li class=""""),_display_(if(condition.state == "open")/*20.48*/{_display_(Seq[Any](format.raw/*20.49*/("""active""")))} else {null} ),format.raw/*20.56*/("""">
        <a href=""""),_display_(/*21.19*/condition/*21.28*/.copy(state = "open").toURL),format.raw/*21.55*/("""">Open <span class="badge">"""),_display_(/*21.83*/openCount),format.raw/*21.92*/("""</span></a>
      </li>
      <li class=""""),_display_(if(condition.state == "closed")/*23.50*/{_display_(Seq[Any](format.raw/*23.51*/("""active""")))} else {null} ),format.raw/*23.58*/("""">
        <a href=""""),_display_(/*24.19*/condition/*24.28*/.copy(state = "closed").toURL),format.raw/*24.57*/("""">Closed <span class="badge">"""),_display_(/*24.87*/closedCount),format.raw/*24.98*/("""</span></a>
      </li>
    </ul>
    <form method="GET" action=""""),_display_(/*27.33*/helpers/*27.40*/.url(repository)),format.raw/*27.56*/("""/"""),_display_(/*27.58*/target),format.raw/*27.64*/("""" id="search-filter-form" class="form-inline pull-right" autocomplete="off">
      <div class="input-group">
        <input type="text" class="form-control" name="q" placeholder="Search..." aria-label="Search all issues" value=""""),_display_(/*29.121*/condition/*29.130*/.toFilterString),format.raw/*29.145*/("""" style="width: 300px;"/>
        <input type="hidden" name="type" value=""""),_display_(/*30.50*/target),format.raw/*30.56*/(""""/>
        <span class="input-group-btn">
          <button type="submit" id="search-btn" class="btn btn-default" aria-label="Search all issues"><i class="fa fa-search"></i></button>
        </span>
      </div>
      """),_display_(if(isEditable)/*35.22*/{_display_(Seq[Any](format.raw/*35.23*/("""
        """),_display_(if(target == "issues")/*36.32*/{_display_(Seq[Any](format.raw/*36.33*/("""
          """),format.raw/*37.11*/("""<a class="btn btn-success" href=""""),_display_(/*37.45*/helpers/*37.52*/.url(repository)),format.raw/*37.68*/("""/issues/new">New issue</a>
        """)))} else {null} ),format.raw/*38.10*/("""
        """),_display_(if(target == "pulls")/*39.31*/{_display_(Seq[Any](format.raw/*39.32*/("""
          """),format.raw/*40.11*/("""<a class="btn btn-success" href=""""),_display_(/*40.45*/helpers/*40.52*/.url(repository)),format.raw/*40.68*/("""/compare">New pull request</a>
        """)))} else {null} ),format.raw/*41.10*/("""
      """)))} else {null} ),format.raw/*42.8*/("""
    """),format.raw/*43.5*/("""</form>
    """),_display_(/*44.6*/gitbucket/*44.15*/.core.issues.html.listparts(target, issues, page, openCount, closedCount, condition, collaborators, milestones, priorities, labels, Some(repository), isManageable)),format.raw/*44.178*/("""
    """),_display_(if(isManageable)/*45.22*/{_display_(Seq[Any](format.raw/*45.23*/("""
      """),format.raw/*46.7*/("""<form id="batcheditForm" method="POST">
        <input type="hidden" name="value"/>
        <input type="hidden" name="checked"/>
        <input type="hidden" name="uri"/>
        <input type="hidden" name="from" value=""""),_display_(/*50.50*/target),format.raw/*50.56*/(""""/>
      </form>
    """)))} else {null} ),format.raw/*52.6*/("""
  """)))}),format.raw/*53.4*/("""
""")))}),format.raw/*54.2*/("""
"""),_display_(if(isManageable)/*55.18*/{_display_(Seq[Any](format.raw/*55.19*/("""
"""),format.raw/*56.1*/("""<script>
$(function()"""),format.raw/*57.13*/("""{"""),format.raw/*57.14*/("""
  """),format.raw/*78.5*/("""

  """),format.raw/*80.3*/("""$('.table-issues input[type=checkbox]').change(function()"""),format.raw/*80.60*/("""{"""),format.raw/*80.61*/("""
    """),format.raw/*81.5*/("""var all = $('.table-issues input[type=checkbox][value]');

    // check all
    if($(this).val() == 'on')"""),format.raw/*84.30*/("""{"""),format.raw/*84.31*/("""
      """),format.raw/*85.7*/("""var flag = $(this).is(":checked");
      all.each(function()"""),format.raw/*86.26*/("""{"""),format.raw/*86.27*/("""
        """),format.raw/*87.9*/("""$(this).prop("checked", flag);
      """),format.raw/*88.7*/("""}"""),format.raw/*88.8*/(""");
    """),format.raw/*89.5*/("""}"""),format.raw/*89.6*/("""

    """),format.raw/*91.5*/("""var count = all.filter(':checked').length;
    // whether all check
    $('.table-issues input[type=checkbox]').filter(':first').prop("checked", count > 0 && count == all.length);

    if(count == 0)"""),format.raw/*95.19*/("""{"""),format.raw/*95.20*/("""
      """),format.raw/*96.7*/("""$('#table-issues-control').show();
      $('#table-issues-batchedit').hide();
    """),format.raw/*98.5*/("""}"""),format.raw/*98.6*/(""" """),format.raw/*98.7*/("""else """),format.raw/*98.12*/("""{"""),format.raw/*98.13*/("""
      """),format.raw/*99.7*/("""$('#batchedit-selected').text(count);
      $('#table-issues-control').hide();
      $('#table-issues-batchedit').show();
    """),format.raw/*102.5*/("""}"""),format.raw/*102.6*/("""
  """),format.raw/*103.3*/("""}"""),format.raw/*103.4*/(""").filter(':first').change();

  var submitBatchEdit = function(action, value) """),format.raw/*105.49*/("""{"""),format.raw/*105.50*/("""
    """),format.raw/*106.5*/("""var checked = $('.table-issues input[type=checkbox][value]').filter(':checked').map(function()"""),format.raw/*106.99*/("""{"""),format.raw/*106.100*/(""" """),format.raw/*106.101*/("""return this.value; """),format.raw/*106.120*/("""}"""),format.raw/*106.121*/(""").get().join();
    var form = $('#batcheditForm');
    form.find('input[name=value]').val(value);
    form.find('input[name=checked]').val(checked);
    form.attr('action', action);
    form.submit();
  """),format.raw/*112.3*/("""}"""),format.raw/*112.4*/(""";

  $('a.toggle-state').click(function()"""),format.raw/*114.39*/("""{"""),format.raw/*114.40*/("""
    """),format.raw/*115.5*/("""submitBatchEdit('"""),_display_(/*115.23*/helpers/*115.30*/.url(repository)),format.raw/*115.46*/("""/issues/batchedit/state', $(this).data('id'));
  """),format.raw/*116.3*/("""}"""),format.raw/*116.4*/(""");
  $('a.toggle-label').click(function()"""),format.raw/*117.39*/("""{"""),format.raw/*117.40*/("""
    """),format.raw/*118.5*/("""submitBatchEdit('"""),_display_(/*118.23*/helpers/*118.30*/.url(repository)),format.raw/*118.46*/("""/issues/batchedit/label', $(this).data('id'));
  """),format.raw/*119.3*/("""}"""),format.raw/*119.4*/(""");
  $('a.toggle-assign').click(function()"""),format.raw/*120.40*/("""{"""),format.raw/*120.41*/("""
    """),format.raw/*121.5*/("""submitBatchEdit('"""),_display_(/*121.23*/helpers/*121.30*/.url(repository)),format.raw/*121.46*/("""/issues/batchedit/assign', $(this).data('name'));
  """),format.raw/*122.3*/("""}"""),format.raw/*122.4*/(""");
  $('a.toggle-milestone').click(function()"""),format.raw/*123.43*/("""{"""),format.raw/*123.44*/("""
    """),format.raw/*124.5*/("""submitBatchEdit('"""),_display_(/*124.23*/helpers/*124.30*/.url(repository)),format.raw/*124.46*/("""/issues/batchedit/milestone', $(this).data('id'));
  """),format.raw/*125.3*/("""}"""),format.raw/*125.4*/(""");
  $('a.toggle-priority').click(function()"""),format.raw/*126.42*/("""{"""),format.raw/*126.43*/("""
    """),format.raw/*127.5*/("""submitBatchEdit('"""),_display_(/*127.23*/helpers/*127.30*/.url(repository)),format.raw/*127.46*/("""/issues/batchedit/priority', $(this).data('id'));
  """),format.raw/*128.3*/("""}"""),format.raw/*128.4*/(""");
"""),format.raw/*129.1*/("""}"""),format.raw/*129.2*/(""");
</script>
""")))} else {null} ),format.raw/*131.2*/("""
"""))
      }
    }
  }

  def render(target:String,issues:List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],page:Int,collaborators:List[String],milestones:List[gitbucket.core.model.Milestone],priorities:List[gitbucket.core.model.Priority],labels:List[gitbucket.core.model.Label],openCount:Int,closedCount:Int,condition:gitbucket.core.service.IssuesService.IssueSearchCondition,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,isEditable:Boolean,isManageable:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(target,issues,page,collaborators,milestones,priorities,labels,openCount,closedCount,condition,repository,isEditable,isManageable)(context)

  def f:((String,List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],Int,List[String],List[gitbucket.core.model.Milestone],List[gitbucket.core.model.Priority],List[gitbucket.core.model.Label],Int,Int,gitbucket.core.service.IssuesService.IssueSearchCondition,gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (target,issues,page,collaborators,milestones,priorities,labels,openCount,closedCount,condition,repository,isEditable,isManageable) => (context) => apply(target,issues,page,collaborators,milestones,priorities,labels,openCount,closedCount,condition,repository,isEditable,isManageable)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/issues/list.scala.html
                  HASH: dfe9bf1b26b75f171dd72968df8a6735239018ba
                  MATRIX: 1017->1|1731->644|1795->642|1823->679|1851->681|1869->690|2015->826|2055->827|2085->831|2103->840|2147->875|2186->876|2218->881|2377->1013|2416->1014|2467->1021|2515->1042|2533->1051|2581->1078|2636->1106|2666->1115|2766->1188|2805->1189|2856->1196|2904->1217|2922->1226|2972->1255|3029->1285|3061->1296|3154->1362|3170->1369|3207->1385|3236->1387|3263->1393|3520->1622|3539->1631|3576->1646|3678->1721|3705->1727|3966->1961|4005->1962|4064->1994|4103->1995|4142->2006|4203->2040|4219->2047|4256->2063|4336->2099|4394->2130|4433->2131|4472->2142|4533->2176|4549->2183|4586->2199|4670->2239|4721->2247|4753->2252|4792->2265|4810->2274|4995->2437|5044->2459|5083->2460|5117->2467|5365->2688|5392->2694|5458->2717|5492->2721|5524->2723|5569->2741|5608->2742|5636->2743|5685->2764|5714->2765|5744->3521|5775->3525|5860->3582|5889->3583|5921->3588|6054->3693|6083->3694|6117->3701|6205->3761|6234->3762|6270->3771|6334->3808|6362->3809|6396->3816|6424->3817|6457->3823|6684->4022|6713->4023|6747->4030|6856->4112|6884->4113|6912->4114|6945->4119|6974->4120|7008->4127|7162->4253|7191->4254|7222->4257|7251->4258|7358->4336|7388->4337|7421->4342|7544->4436|7575->4437|7606->4438|7655->4457|7686->4458|7918->4662|7947->4663|8017->4704|8047->4705|8080->4710|8126->4728|8143->4735|8181->4751|8258->4800|8287->4801|8357->4842|8387->4843|8420->4848|8466->4866|8483->4873|8521->4889|8598->4938|8627->4939|8698->4981|8728->4982|8761->4987|8807->5005|8824->5012|8862->5028|8942->5080|8971->5081|9045->5126|9075->5127|9108->5132|9154->5150|9171->5157|9209->5173|9290->5226|9319->5227|9392->5271|9422->5272|9455->5277|9501->5295|9518->5302|9556->5318|9636->5370|9665->5371|9696->5374|9725->5375|9783->5389
                  LINES: 14->1|29->15|32->14|33->16|34->17|34->17|34->17|34->17|35->18|35->18|35->18|35->18|36->19|37->20|37->20|37->20|38->21|38->21|38->21|38->21|38->21|40->23|40->23|40->23|41->24|41->24|41->24|41->24|41->24|44->27|44->27|44->27|44->27|44->27|46->29|46->29|46->29|47->30|47->30|52->35|52->35|53->36|53->36|54->37|54->37|54->37|54->37|55->38|56->39|56->39|57->40|57->40|57->40|57->40|58->41|59->42|60->43|61->44|61->44|61->44|62->45|62->45|63->46|67->50|67->50|69->52|70->53|71->54|72->55|72->55|73->56|74->57|74->57|75->78|77->80|77->80|77->80|78->81|81->84|81->84|82->85|83->86|83->86|84->87|85->88|85->88|86->89|86->89|88->91|92->95|92->95|93->96|95->98|95->98|95->98|95->98|95->98|96->99|99->102|99->102|100->103|100->103|102->105|102->105|103->106|103->106|103->106|103->106|103->106|103->106|109->112|109->112|111->114|111->114|112->115|112->115|112->115|112->115|113->116|113->116|114->117|114->117|115->118|115->118|115->118|115->118|116->119|116->119|117->120|117->120|118->121|118->121|118->121|118->121|119->122|119->122|120->123|120->123|121->124|121->124|121->124|121->124|122->125|122->125|123->126|123->126|124->127|124->127|124->127|124->127|125->128|125->128|126->129|126->129|128->131
                  -- GENERATED --
              */
          