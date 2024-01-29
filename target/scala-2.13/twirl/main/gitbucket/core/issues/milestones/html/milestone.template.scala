
package gitbucket.core.issues.milestones.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object milestone extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template11[String,List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],Int,List[String],List[gitbucket.core.model.Priority],List[gitbucket.core.model.Label],gitbucket.core.service.IssuesService.IssueSearchCondition,List[(gitbucket.core.model.Milestone, Int, Int)],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(state: String,
  issues: List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],
  page: Int,
  collaborators: List[String],
  priorities: List[gitbucket.core.model.Priority],
  labels: List[gitbucket.core.model.Label],
  condition: gitbucket.core.service.IssuesService.IssueSearchCondition,
  milestones: List[(gitbucket.core.model.Milestone, Int, Int)],
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  hasWritePermission: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*11.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*12.2*/gitbucket/*12.11*/.core.html.main(s"Milestones - ${repository.owner}/${repository.name}")/*12.82*/{_display_(Seq[Any](format.raw/*12.83*/("""
  """),_display_(/*13.4*/gitbucket/*13.13*/.core.html.menu("milestones", repository)/*13.54*/{_display_(Seq[Any](format.raw/*13.55*/("""
    """),_display_(/*14.6*/milestones/*14.16*/.map/*14.20*/ { case (milestone, openCount, closedCount) =>_display_(Seq[Any](format.raw/*14.66*/("""
      """),format.raw/*15.7*/("""<table class="table table-issues">
      <tbody>
        <tr>
          <td style="padding-top: 15px; padding-bottom: 15px;">
            <div class="milestone row">
              <div class="col-md-4">
                <a class="milestone-title">"""),_display_(/*21.45*/milestone/*21.54*/.title),format.raw/*21.60*/("""</a>
                <div>
                """),_display_(if(milestone.closedDate.isDefined)/*23.52*/{_display_(Seq[Any](format.raw/*23.53*/("""
                  """),format.raw/*24.19*/("""<span class="muted">Closed """),_display_(/*24.47*/gitbucket/*24.56*/.core.helper.html.datetimeago(milestone.closedDate.get)),format.raw/*24.111*/("""</span>
                """)))}else/*25.24*/{_display_(Seq[Any](format.raw/*25.25*/("""
                  """),_display_(/*26.20*/milestone/*26.29*/.dueDate.map/*26.41*/ { dueDate =>_display_(Seq[Any](format.raw/*26.54*/("""
                    """),_display_(if(helpers.isPast(dueDate))/*27.49*/{_display_(Seq[Any](format.raw/*27.50*/("""
                      """),format.raw/*28.23*/("""<i class="octicon octicon-alert" style="color:#BD2C00;"></i>
                      <span class="muted milestone-alert">Due by """),_display_(/*29.67*/helpers/*29.74*/.date(dueDate)),format.raw/*29.88*/("""</span>
                    """)))}else/*30.28*/{_display_(Seq[Any](format.raw/*30.29*/("""
                      """),format.raw/*31.23*/("""<span class="muted">Due by """),_display_(/*31.51*/helpers/*31.58*/.date(dueDate)),format.raw/*31.72*/("""</span>
                    """)))}),format.raw/*32.22*/("""
                  """)))}/*33.20*/.getOrElse/*33.30*/ {_display_(Seq[Any](format.raw/*33.32*/("""
                    """),format.raw/*34.21*/("""<span class="muted">No due date</span>
                  """)))}),format.raw/*35.20*/("""
                """)))}),format.raw/*36.18*/("""
                """),format.raw/*37.17*/("""</div>
              </div>
              <div class="col-md-8">
                """),_display_(/*40.18*/gitbucket/*40.27*/.core.issues.milestones.html.progress(openCount + closedCount, closedCount)),format.raw/*40.102*/("""
              """),format.raw/*41.15*/("""<div>
                <div>
                  """),_display_(if(closedCount == 0)/*43.40*/{_display_(Seq[Any](format.raw/*43.41*/("""
                    """),format.raw/*44.21*/("""0%
                  """)))}else/*45.26*/{_display_(Seq[Any](format.raw/*45.27*/("""
                    """),_display_(/*46.22*/((closedCount.toDouble / (openCount + closedCount).toDouble * 100).toInt)),format.raw/*46.95*/("""%
                  """)))}),format.raw/*47.20*/(""" """),format.raw/*47.21*/("""<span class="muted">complete</span> &nbsp;&nbsp;
                  """),_display_(/*48.20*/openCount),format.raw/*48.29*/(""" """),format.raw/*48.30*/("""<span class="muted">open</span> &nbsp;&nbsp;
                  """),_display_(/*49.20*/closedCount),format.raw/*49.31*/(""" """),format.raw/*49.32*/("""<span class="muted">closed</span>
                </div>
                <div class="milestone-menu">
                """),_display_(if(hasWritePermission)/*52.40*/{_display_(Seq[Any](format.raw/*52.41*/("""
                  """),format.raw/*53.19*/("""<a href=""""),_display_(/*53.29*/helpers/*53.36*/.url(repository)),format.raw/*53.52*/("""/issues/milestones/"""),_display_(/*53.72*/milestone/*53.81*/.milestoneId),format.raw/*53.93*/("""/edit">Edit</a> &nbsp;&nbsp;
                  """),_display_(if(milestone.closedDate.isDefined)/*54.54*/{_display_(Seq[Any](format.raw/*54.55*/("""
                    """),format.raw/*55.21*/("""<a href=""""),_display_(/*55.31*/helpers/*55.38*/.url(repository)),format.raw/*55.54*/("""/issues/milestones/"""),_display_(/*55.74*/milestone/*55.83*/.milestoneId),format.raw/*55.95*/("""/open">Open</a> &nbsp;&nbsp;
                  """)))}else/*56.26*/{_display_(Seq[Any](format.raw/*56.27*/("""
                    """),format.raw/*57.21*/("""<a href=""""),_display_(/*57.31*/helpers/*57.38*/.url(repository)),format.raw/*57.54*/("""/issues/milestones/"""),_display_(/*57.74*/milestone/*57.83*/.milestoneId),format.raw/*57.95*/("""/close">Close</a> &nbsp;&nbsp;
                  """)))}),format.raw/*58.20*/("""
                  """),format.raw/*59.19*/("""<a href=""""),_display_(/*59.29*/helpers/*59.36*/.url(repository)),format.raw/*59.52*/("""/issues/milestones/"""),_display_(/*59.72*/milestone/*59.81*/.milestoneId),format.raw/*59.93*/("""/delete" class="delete">Delete</a>
                """)))} else {null} ),format.raw/*60.18*/("""
                """),format.raw/*61.17*/("""</div>
              </div>
              </div>
            </div>
            """),_display_(/*65.14*/milestone/*65.23*/.description.map/*65.39*/ { description =>_display_(Seq[Any](format.raw/*65.56*/("""
              """),format.raw/*66.15*/("""<div class="milestone-description markdown-body">
                """),_display_(/*67.18*/helpers/*67.25*/.markdown(
                  markdown         = description,
                  repository       = repository,
                  branch           = repository.repository.defaultBranch,
                  enableWikiLink   = false,
                  enableRefsLink   = false,
                  enableLineBreaks = true
                )),format.raw/*74.18*/("""
              """),format.raw/*75.15*/("""</div>
            """)))}),format.raw/*76.14*/("""
        """),format.raw/*77.9*/("""</td>
        </tr>
      </tbody>
    </table>
      <ul class="nav nav-pills pull-left" style="line-height: 14px; margin-bottom: 10px;">
        <li class=""""),_display_(if(condition.state == "open")/*82.50*/{_display_(Seq[Any](format.raw/*82.51*/("""active""")))} else {null} ),format.raw/*82.58*/("""">
          <a href=""""),_display_(/*83.21*/context/*83.28*/.path),format.raw/*83.33*/("""/"""),_display_(/*83.35*/repository/*83.45*/.owner),format.raw/*83.51*/("""/"""),_display_(/*83.53*/repository/*83.63*/.name),format.raw/*83.68*/("""/milestone/"""),_display_(/*83.80*/milestone/*83.89*/.milestoneId),format.raw/*83.101*/("""">Open <span class="badge">"""),_display_(/*83.129*/openCount),format.raw/*83.138*/("""</span></a>
        </li>
        <li class=""""),_display_(if(condition.state == "closed")/*85.52*/{_display_(Seq[Any](format.raw/*85.53*/("""active""")))} else {null} ),format.raw/*85.60*/("""">
          <a href=""""),_display_(/*86.21*/context/*86.28*/.path),format.raw/*86.33*/("""/"""),_display_(/*86.35*/repository/*86.45*/.owner),format.raw/*86.51*/("""/"""),_display_(/*86.53*/repository/*86.63*/.name),format.raw/*86.68*/("""/milestone/"""),_display_(/*86.80*/milestone/*86.89*/.milestoneId),format.raw/*86.101*/("""?state=closed">Closed <span class="badge">"""),_display_(/*86.144*/closedCount),format.raw/*86.155*/("""</span></a>
        </li>
      </ul>
      """),_display_(/*89.8*/gitbucket/*89.17*/.core.issues.milestones.html.listparts(issues, page, openCount, closedCount, condition, collaborators, milestones.map(p => p._1), priorities, labels, Some(repository), hasWritePermission)),format.raw/*89.204*/("""
      """),_display_(if(hasWritePermission)/*90.30*/{_display_(Seq[Any](format.raw/*90.31*/("""
        """),format.raw/*91.9*/("""<form id="batcheditForm" method="POST">
          <input type="hidden" name="value"/>
          <input type="hidden" name="checked"/>
          <input type="hidden" name="uri" value=""""),_display_(/*94.51*/context/*94.58*/.path),format.raw/*94.63*/("""/"""),_display_(/*94.65*/repository/*94.75*/.owner),format.raw/*94.81*/("""/"""),_display_(/*94.83*/repository/*94.93*/.name),format.raw/*94.98*/("""/milestone/"""),_display_(/*94.110*/milestone/*94.119*/.milestoneId),_display_(if(condition.state=="closed")/*94.161*/{_display_(Seq[Any](format.raw/*94.162*/("""?state=closed""")))} else {null} ),format.raw/*94.176*/("""">
          <input type="hidden" name="from" value="milestone"/>
        </form>
      """)))} else {null} ),format.raw/*97.8*/("""
    """)))}),format.raw/*98.6*/("""
  """)))}),format.raw/*99.4*/("""
""")))}),format.raw/*100.2*/("""
"""),_display_(if(hasWritePermission)/*101.24*/{_display_(Seq[Any](format.raw/*101.25*/("""
  """),format.raw/*102.3*/("""<script>
    $(function()"""),format.raw/*103.17*/("""{"""),format.raw/*103.18*/("""
      """),format.raw/*104.7*/("""$('a.delete').click(function()"""),format.raw/*104.37*/("""{"""),format.raw/*104.38*/("""
        """),format.raw/*105.9*/("""return confirm('Once you delete this milestone, there is no going back.\nAre you sure?');
      """),format.raw/*106.7*/("""}"""),format.raw/*106.8*/(""");

      $('.table-issues input[type=checkbox]').change(function()"""),format.raw/*108.64*/("""{"""),format.raw/*108.65*/("""
        """),format.raw/*109.9*/("""var all = $('.table-issues input[type=checkbox][value]');

        // check all
        if($(this).val() == 'on')"""),format.raw/*112.34*/("""{"""),format.raw/*112.35*/("""
          """),format.raw/*113.11*/("""var flag = $(this).is(":checked");
          all.each(function()"""),format.raw/*114.30*/("""{"""),format.raw/*114.31*/("""
            """),format.raw/*115.13*/("""$(this).prop("checked", flag);
          """),format.raw/*116.11*/("""}"""),format.raw/*116.12*/(""");
        """),format.raw/*117.9*/("""}"""),format.raw/*117.10*/("""

        """),format.raw/*119.9*/("""var count = all.filter(':checked').length;
        // whether all check
        $('.table-issues input[type=checkbox]').filter(':first').prop("checked", count > 0 && count == all.length);

        if(count == 0)"""),format.raw/*123.23*/("""{"""),format.raw/*123.24*/("""
          """),format.raw/*124.11*/("""$('#table-issues-control').show();
          $('#table-issues-batchedit').hide();
        """),format.raw/*126.9*/("""}"""),format.raw/*126.10*/(""" """),format.raw/*126.11*/("""else """),format.raw/*126.16*/("""{"""),format.raw/*126.17*/("""
          """),format.raw/*127.11*/("""$('#batchedit-selected').text(count);
          $('#table-issues-control').hide();
          $('#table-issues-batchedit').show();
        """),format.raw/*130.9*/("""}"""),format.raw/*130.10*/("""
      """),format.raw/*131.7*/("""}"""),format.raw/*131.8*/(""").filter(':first').change();

      var submitBatchEdit = function(action, value) """),format.raw/*133.53*/("""{"""),format.raw/*133.54*/("""
        """),format.raw/*134.9*/("""var checked = $('.table-issues input[type=checkbox][value]').filter(':checked').map(function()"""),format.raw/*134.103*/("""{"""),format.raw/*134.104*/(""" """),format.raw/*134.105*/("""return this.value; """),format.raw/*134.124*/("""}"""),format.raw/*134.125*/(""").get().join();
        var form = $('#batcheditForm');
        form.find('input[name=value]').val(value);
        form.find('input[name=checked]').val(checked);
        form.attr('action', action);
        form.submit();
      """),format.raw/*140.7*/("""}"""),format.raw/*140.8*/(""";

      $('a.toggle-state').click(function()"""),format.raw/*142.43*/("""{"""),format.raw/*142.44*/("""
        """),format.raw/*143.9*/("""submitBatchEdit('"""),_display_(/*143.27*/helpers/*143.34*/.url(repository)),format.raw/*143.50*/("""/issues/batchedit/state', $(this).data('id'));
      """),format.raw/*144.7*/("""}"""),format.raw/*144.8*/(""");
      $('a.toggle-label').click(function()"""),format.raw/*145.43*/("""{"""),format.raw/*145.44*/("""
        """),format.raw/*146.9*/("""submitBatchEdit('"""),_display_(/*146.27*/helpers/*146.34*/.url(repository)),format.raw/*146.50*/("""/issues/batchedit/label', $(this).data('id'));
      """),format.raw/*147.7*/("""}"""),format.raw/*147.8*/(""");
      $('a.toggle-assign').click(function()"""),format.raw/*148.44*/("""{"""),format.raw/*148.45*/("""
        """),format.raw/*149.9*/("""submitBatchEdit('"""),_display_(/*149.27*/helpers/*149.34*/.url(repository)),format.raw/*149.50*/("""/issues/batchedit/assign', $(this).data('name'));
      """),format.raw/*150.7*/("""}"""),format.raw/*150.8*/(""");
    """),format.raw/*151.5*/("""}"""),format.raw/*151.6*/(""");
  </script>
""")))} else {null} ),format.raw/*153.2*/("""

"""))
      }
    }
  }

  def render(state:String,issues:List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],page:Int,collaborators:List[String],priorities:List[gitbucket.core.model.Priority],labels:List[gitbucket.core.model.Label],condition:gitbucket.core.service.IssuesService.IssueSearchCondition,milestones:List[(gitbucket.core.model.Milestone, Int, Int)],repository:gitbucket.core.service.RepositoryService.RepositoryInfo,hasWritePermission:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(state,issues,page,collaborators,priorities,labels,condition,milestones,repository,hasWritePermission)(context)

  def f:((String,List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],Int,List[String],List[gitbucket.core.model.Priority],List[gitbucket.core.model.Label],gitbucket.core.service.IssuesService.IssueSearchCondition,List[(gitbucket.core.model.Milestone, Int, Int)],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (state,issues,page,collaborators,priorities,labels,condition,milestones,repository,hasWritePermission) => (context) => apply(state,issues,page,collaborators,priorities,labels,condition,milestones,repository,hasWritePermission)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/issues/milestones/milestone.scala.html
                  HASH: 655f6399fa775dfdbf36ca19083d8b78d6dc00ee
                  MATRIX: 1029->1|1699->599|1763->635|1781->644|1861->715|1900->716|1930->720|1948->729|1998->770|2037->771|2069->777|2088->787|2101->791|2185->837|2219->844|2493->1091|2511->1100|2538->1106|2643->1184|2682->1185|2729->1204|2784->1232|2802->1241|2879->1296|2927->1327|2966->1328|3013->1348|3031->1357|3052->1369|3103->1382|3179->1431|3218->1432|3269->1455|3423->1582|3439->1589|3474->1603|3526->1638|3565->1639|3616->1662|3671->1690|3687->1697|3722->1711|3782->1740|3821->1760|3840->1770|3880->1772|3929->1793|4018->1851|4067->1869|4112->1886|4221->1968|4239->1977|4336->2052|4379->2067|4473->2134|4512->2135|4561->2156|4606->2184|4645->2185|4694->2207|4788->2280|4840->2301|4869->2302|4964->2370|4994->2379|5023->2380|5114->2444|5146->2455|5175->2456|5343->2597|5382->2598|5429->2617|5466->2627|5482->2634|5519->2650|5566->2670|5584->2679|5617->2691|5726->2773|5765->2774|5814->2795|5851->2805|5867->2812|5904->2828|5951->2848|5969->2857|6002->2869|6073->2923|6112->2924|6161->2945|6198->2955|6214->2962|6251->2978|6298->2998|6316->3007|6349->3019|6430->3069|6477->3088|6514->3098|6530->3105|6567->3121|6614->3141|6632->3150|6665->3162|6761->3214|6806->3231|6914->3312|6932->3321|6957->3337|7012->3354|7055->3369|7149->3436|7165->3443|7517->3774|7560->3789|7611->3809|7647->3818|7862->4006|7901->4007|7952->4014|8002->4037|8018->4044|8044->4049|8073->4051|8092->4061|8119->4067|8148->4069|8167->4079|8193->4084|8232->4096|8250->4105|8284->4117|8340->4145|8371->4154|8475->4231|8514->4232|8565->4239|8615->4262|8631->4269|8657->4274|8686->4276|8705->4286|8732->4292|8761->4294|8780->4304|8806->4309|8845->4321|8863->4330|8897->4342|8968->4385|9001->4396|9072->4441|9090->4450|9299->4637|9356->4667|9395->4668|9431->4677|9642->4861|9658->4868|9684->4873|9713->4875|9732->4885|9759->4891|9788->4893|9807->4903|9833->4908|9873->4920|9892->4929|9955->4971|9995->4972|10054->4986|10186->5075|10222->5081|10256->5085|10289->5087|10341->5111|10381->5112|10412->5115|10466->5140|10496->5141|10531->5148|10590->5178|10620->5179|10657->5188|10781->5284|10810->5285|10906->5352|10936->5353|10973->5362|11115->5475|11145->5476|11185->5487|11278->5551|11308->5552|11350->5565|11420->5606|11450->5607|11489->5618|11519->5619|11557->5629|11797->5840|11827->5841|11867->5852|11985->5942|12015->5943|12045->5944|12079->5949|12109->5950|12149->5961|12315->6099|12345->6100|12380->6107|12409->6108|12520->6190|12550->6191|12587->6200|12711->6294|12742->6295|12773->6296|12822->6315|12853->6316|13109->6544|13138->6545|13212->6590|13242->6591|13279->6600|13325->6618|13342->6625|13380->6641|13461->6694|13490->6695|13564->6740|13594->6741|13631->6750|13677->6768|13694->6775|13732->6791|13813->6844|13842->6845|13917->6891|13947->6892|13984->6901|14030->6919|14047->6926|14085->6942|14169->6998|14198->6999|14233->7006|14262->7007|14322->7023
                  LINES: 14->1|26->11|29->12|29->12|29->12|29->12|30->13|30->13|30->13|30->13|31->14|31->14|31->14|31->14|32->15|38->21|38->21|38->21|40->23|40->23|41->24|41->24|41->24|41->24|42->25|42->25|43->26|43->26|43->26|43->26|44->27|44->27|45->28|46->29|46->29|46->29|47->30|47->30|48->31|48->31|48->31|48->31|49->32|50->33|50->33|50->33|51->34|52->35|53->36|54->37|57->40|57->40|57->40|58->41|60->43|60->43|61->44|62->45|62->45|63->46|63->46|64->47|64->47|65->48|65->48|65->48|66->49|66->49|66->49|69->52|69->52|70->53|70->53|70->53|70->53|70->53|70->53|70->53|71->54|71->54|72->55|72->55|72->55|72->55|72->55|72->55|72->55|73->56|73->56|74->57|74->57|74->57|74->57|74->57|74->57|74->57|75->58|76->59|76->59|76->59|76->59|76->59|76->59|76->59|77->60|78->61|82->65|82->65|82->65|82->65|83->66|84->67|84->67|91->74|92->75|93->76|94->77|99->82|99->82|99->82|100->83|100->83|100->83|100->83|100->83|100->83|100->83|100->83|100->83|100->83|100->83|100->83|100->83|100->83|102->85|102->85|102->85|103->86|103->86|103->86|103->86|103->86|103->86|103->86|103->86|103->86|103->86|103->86|103->86|103->86|103->86|106->89|106->89|106->89|107->90|107->90|108->91|111->94|111->94|111->94|111->94|111->94|111->94|111->94|111->94|111->94|111->94|111->94|111->94|111->94|111->94|114->97|115->98|116->99|117->100|118->101|118->101|119->102|120->103|120->103|121->104|121->104|121->104|122->105|123->106|123->106|125->108|125->108|126->109|129->112|129->112|130->113|131->114|131->114|132->115|133->116|133->116|134->117|134->117|136->119|140->123|140->123|141->124|143->126|143->126|143->126|143->126|143->126|144->127|147->130|147->130|148->131|148->131|150->133|150->133|151->134|151->134|151->134|151->134|151->134|151->134|157->140|157->140|159->142|159->142|160->143|160->143|160->143|160->143|161->144|161->144|162->145|162->145|163->146|163->146|163->146|163->146|164->147|164->147|165->148|165->148|166->149|166->149|166->149|166->149|167->150|167->150|168->151|168->151|170->153
                  -- GENERATED --
              */
          