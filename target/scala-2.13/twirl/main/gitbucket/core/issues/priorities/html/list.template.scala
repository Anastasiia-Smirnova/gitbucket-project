
package gitbucket.core.issues.priorities.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object list extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[List[gitbucket.core.model.Priority],Map[String, Int],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(priorities: List[gitbucket.core.model.Priority],
  counts: Map[String, Int],
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  hasWritePermission: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*5.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*6.2*/gitbucket/*6.11*/.core.html.main(s"Priorities - ${repository.owner}/${repository.name}")/*6.82*/{_display_(Seq[Any](format.raw/*6.83*/("""
  """),_display_(/*7.4*/gitbucket/*7.13*/.core.html.menu("priorities", repository)/*7.54*/{_display_(Seq[Any](format.raw/*7.55*/("""
    """),_display_(if(hasWritePermission)/*8.28*/{_display_(Seq[Any](format.raw/*8.29*/("""
      """),format.raw/*9.7*/("""<div class="pull-right" style="margin-bottom: 10px;">
        <a class="btn btn-success" href="javascript:void(0);" id="new-priority-button">New priority</a>
      </div>
    """)))} else {null} ),format.raw/*12.6*/("""
    """),format.raw/*13.5*/("""<table class="table table-bordered table-hover table-issues" id="new-priority-table" style="display: none;">
      <tr><td></td></tr>
    </table>
    <table id="priorities-table" class="table table-bordered table-hover table-issues">
      <thead>
        <tr id="priority-row-header">
          <th>"""),_display_(/*19.16*/priorities/*19.26*/.size),format.raw/*19.31*/(""" """),format.raw/*19.32*/("""priorities</th>
        </tr>
      </thead>
      <tbody>
        """),_display_(/*23.10*/priorities/*23.20*/.map/*23.24*/ { priority =>_display_(Seq[Any](format.raw/*23.38*/("""
          """),_display_(/*24.12*/gitbucket/*24.21*/.core.issues.priorities.html.priority(priority, counts, repository, hasWritePermission)),format.raw/*24.108*/("""
        """)))}),format.raw/*25.10*/("""
        """),format.raw/*26.9*/("""<tr id="priority-no-priorities" """),_display_(if(!priorities.isEmpty)/*26.65*/{_display_(Seq[Any](format.raw/*26.66*/(""" """),format.raw/*26.67*/("""style="display:none" """)))} else {null} ),format.raw/*26.89*/(""">
          <td style="padding: 20px; background-color: #eee; text-align: center;">
            No priorities to show.
            """),_display_(if(hasWritePermission)/*29.36*/{_display_(Seq[Any](format.raw/*29.37*/("""
              """),format.raw/*30.15*/("""Click on the "New priority" button above to create one.
            """)))} else {null} ),format.raw/*31.14*/("""
          """),format.raw/*32.11*/("""</td>
        </tr>
      </tbody>
    </table>
  """)))}),format.raw/*36.4*/("""
""")))}),format.raw/*37.2*/("""
"""),format.raw/*38.1*/("""<script>
$(function()"""),format.raw/*39.13*/("""{"""),format.raw/*39.14*/("""
  """),format.raw/*40.3*/("""$('#new-priority-button').click(function(e)"""),format.raw/*40.46*/("""{"""),format.raw/*40.47*/("""
    """),format.raw/*41.5*/("""if($('#edit-priority-area-new').length != 0)"""),format.raw/*41.49*/("""{"""),format.raw/*41.50*/("""
      """),format.raw/*42.7*/("""$('div#edit-priority-area-new').remove();
      $('#new-priority-table').hide();
    """),format.raw/*44.5*/("""}"""),format.raw/*44.6*/(""" """),format.raw/*44.7*/("""else """),format.raw/*44.12*/("""{"""),format.raw/*44.13*/("""
      """),format.raw/*45.7*/("""$.get('"""),_display_(/*45.15*/helpers/*45.22*/.url(repository)),format.raw/*45.38*/("""/issues/priorities/new',
        function(data)"""),format.raw/*46.23*/("""{"""),format.raw/*46.24*/("""
          """),format.raw/*47.11*/("""$('#new-priority-table').show().find('tr td').append(data);
        """),format.raw/*48.9*/("""}"""),format.raw/*48.10*/("""
      """),format.raw/*49.7*/(""");
    """),format.raw/*50.5*/("""}"""),format.raw/*50.6*/("""
  """),format.raw/*51.3*/("""}"""),format.raw/*51.4*/(""");
  """),_display_(if(hasWritePermission)/*52.26*/{_display_(Seq[Any](format.raw/*52.27*/("""
    """),format.raw/*53.5*/("""$('#priorities-table tbody').sortable("""),format.raw/*53.43*/("""{"""),format.raw/*53.44*/("""
      """),format.raw/*54.7*/("""axis: 'y',
      cursor: 'move',
      helper: function (e, ui) """),format.raw/*56.32*/("""{"""),format.raw/*56.33*/("""
        """),format.raw/*57.9*/("""ui.children().each(function() """),format.raw/*57.39*/("""{"""),format.raw/*57.40*/("""
          """),format.raw/*58.11*/("""$(this).width($(this).width());
        """),format.raw/*59.9*/("""}"""),format.raw/*59.10*/(""");
        return ui;
      """),format.raw/*61.7*/("""}"""),format.raw/*61.8*/(""",
      handle: '.priority-sort-handle',
      update: function() """),format.raw/*63.26*/("""{"""),format.raw/*63.27*/("""
        """),format.raw/*64.9*/("""var ids = [];
        $('tr.priority-row').each(function(idx, elem) """),format.raw/*65.55*/("""{"""),format.raw/*65.56*/("""
          """),format.raw/*66.11*/("""ids.push($(elem).attr('id').replace('priority-row-', ''));
        """),format.raw/*67.9*/("""}"""),format.raw/*67.10*/(""");
        $.post('"""),_display_(/*68.18*/helpers/*68.25*/.url(repository)),format.raw/*68.41*/("""/issues/priorities/reorder', """),format.raw/*68.70*/("""{"""),format.raw/*68.71*/("""
          """),format.raw/*69.11*/("""'order' : ids.join(',')
        """),format.raw/*70.9*/("""}"""),format.raw/*70.10*/(""").fail(function(xhr, status, error)"""),format.raw/*70.45*/("""{"""),format.raw/*70.46*/("""
          """),format.raw/*71.11*/("""alert('Unable to reorder priorities.');
        """),format.raw/*72.9*/("""}"""),format.raw/*72.10*/(""");
      """),format.raw/*73.7*/("""}"""),format.raw/*73.8*/("""
    """),format.raw/*74.5*/("""}"""),format.raw/*74.6*/(""");
  """)))} else {null} ),format.raw/*75.4*/("""
"""),format.raw/*76.1*/("""}"""),format.raw/*76.2*/(""");

function deletePriority(priorityId)"""),format.raw/*78.36*/("""{"""),format.raw/*78.37*/("""
  """),format.raw/*79.3*/("""if(confirm('Once you delete this priority, there is no going back.\nAre you sure?'))"""),format.raw/*79.87*/("""{"""),format.raw/*79.88*/("""
    """),format.raw/*80.5*/("""$.post('"""),_display_(/*80.14*/helpers/*80.21*/.url(repository)),format.raw/*80.37*/("""/issues/priorities/' + priorityId + '/delete', function()"""),format.raw/*80.94*/("""{"""),format.raw/*80.95*/("""
      """),format.raw/*81.7*/("""$('tr#priority-row-' + priorityId).remove();
      if ($('tr.priority-row').size() == 0) """),format.raw/*82.45*/("""{"""),format.raw/*82.46*/("""
        """),format.raw/*83.9*/("""$('#priority-no-priorities').show();
      """),format.raw/*84.7*/("""}"""),format.raw/*84.8*/("""
      """),format.raw/*85.7*/("""updatePriorityCount();
    """),format.raw/*86.5*/("""}"""),format.raw/*86.6*/(""");
  """),format.raw/*87.3*/("""}"""),format.raw/*87.4*/("""
"""),format.raw/*88.1*/("""}"""),format.raw/*88.2*/("""

"""),format.raw/*90.1*/("""function editPriority(priorityId)"""),format.raw/*90.34*/("""{"""),format.raw/*90.35*/("""
  """),format.raw/*91.3*/("""$.get('"""),_display_(/*91.11*/helpers/*91.18*/.url(repository)),format.raw/*91.34*/("""/issues/priorities/' + priorityId + '/edit',
    function(data)"""),format.raw/*92.19*/("""{"""),format.raw/*92.20*/("""
      """),format.raw/*93.7*/("""$('#priority-' + priorityId).hide().parent().append(data);
    """),format.raw/*94.5*/("""}"""),format.raw/*94.6*/("""
  """),format.raw/*95.3*/(""");
"""),format.raw/*96.1*/("""}"""),format.raw/*96.2*/("""

"""),format.raw/*98.1*/("""function updatePriorityCount() """),format.raw/*98.32*/("""{"""),format.raw/*98.33*/("""
  """),format.raw/*99.3*/("""var $counter = $('#priority-row-header span');
  $counter.text($counter.text().replace(/\d+/, $('tr.priority-row').size()));
"""),format.raw/*101.1*/("""}"""),format.raw/*101.2*/("""

"""),format.raw/*103.1*/("""function setDefaultPriority(priorityId)"""),format.raw/*103.40*/("""{"""),format.raw/*103.41*/("""
  """),format.raw/*104.3*/("""var $a = $('a[data-id="' + priorityId + '"].priority-default');
  var isDefault = $a.data('default');
  $.post('"""),_display_(/*106.12*/helpers/*106.19*/.url(repository)),format.raw/*106.35*/("""/issues/priorities/default',
    """),format.raw/*107.5*/("""{"""),format.raw/*107.6*/(""" """),format.raw/*107.7*/("""priorityId: isDefault ? '' : priorityId """),format.raw/*107.47*/("""}"""),format.raw/*107.48*/(""",
    function()"""),format.raw/*108.15*/("""{"""),format.raw/*108.16*/("""
      """),format.raw/*109.7*/("""$('.priority-default')
        .removeClass('priority-default-selected')
        .data('default', false)
        .attr('title', 'Set as default');
      if (!isDefault) """),format.raw/*113.23*/("""{"""),format.raw/*113.24*/("""
        """),format.raw/*114.9*/("""$a
          .addClass('priority-default-selected')
          .data('default', true)
          .attr('title', 'Unset as default');
      """),format.raw/*118.7*/("""}"""),format.raw/*118.8*/("""
    """),format.raw/*119.5*/("""}"""),format.raw/*119.6*/("""
  """),format.raw/*120.3*/(""");
"""),format.raw/*121.1*/("""}"""),format.raw/*121.2*/("""
"""),format.raw/*122.1*/("""</script>
"""))
      }
    }
  }

  def render(priorities:List[gitbucket.core.model.Priority],counts:Map[String, Int],repository:gitbucket.core.service.RepositoryService.RepositoryInfo,hasWritePermission:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(priorities,counts,repository,hasWritePermission)(context)

  def f:((List[gitbucket.core.model.Priority],Map[String, Int],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (priorities,counts,repository,hasWritePermission) => (context) => apply(priorities,counts,repository,hasWritePermission)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/issues/priorities/list.scala.html
                  HASH: c6dd104fc2713388abdf367957161b782ec5b880
                  MATRIX: 736->1|1041->235|1104->271|1121->280|1200->351|1238->352|1267->356|1284->365|1333->406|1371->407|1425->435|1463->436|1496->443|1715->619|1747->624|2076->926|2095->936|2121->941|2150->942|2245->1010|2264->1020|2277->1024|2329->1038|2368->1050|2386->1059|2495->1146|2536->1156|2572->1165|2655->1221|2694->1222|2723->1223|2789->1245|2970->1399|3009->1400|3052->1415|3165->1484|3204->1495|3285->1546|3317->1548|3345->1549|3394->1570|3423->1571|3453->1574|3524->1617|3553->1618|3585->1623|3657->1667|3686->1668|3720->1675|3832->1760|3860->1761|3888->1762|3921->1767|3950->1768|3984->1775|4019->1783|4035->1790|4072->1806|4147->1853|4176->1854|4215->1865|4310->1933|4339->1934|4373->1941|4407->1948|4435->1949|4465->1952|4493->1953|4548->1981|4587->1982|4619->1987|4685->2025|4714->2026|4748->2033|4840->2097|4869->2098|4905->2107|4963->2137|4992->2138|5031->2149|5098->2189|5127->2190|5182->2218|5210->2219|5304->2285|5333->2286|5369->2295|5465->2363|5494->2364|5533->2375|5627->2442|5656->2443|5703->2463|5719->2470|5756->2486|5813->2515|5842->2516|5881->2527|5940->2559|5969->2560|6032->2595|6061->2596|6100->2607|6175->2655|6204->2656|6240->2665|6268->2666|6300->2671|6328->2672|6377->2678|6405->2679|6433->2680|6500->2719|6529->2720|6559->2723|6671->2807|6700->2808|6732->2813|6768->2822|6784->2829|6821->2845|6906->2902|6935->2903|6969->2910|7086->2999|7115->3000|7151->3009|7221->3052|7249->3053|7283->3060|7337->3087|7365->3088|7397->3093|7425->3094|7453->3095|7481->3096|7510->3098|7571->3131|7600->3132|7630->3135|7665->3143|7681->3150|7718->3166|7809->3229|7838->3230|7872->3237|7962->3300|7990->3301|8020->3304|8050->3307|8078->3308|8107->3310|8166->3341|8195->3342|8225->3345|8378->3470|8407->3471|8437->3473|8505->3512|8535->3513|8566->3516|8707->3629|8724->3636|8762->3652|8823->3685|8852->3686|8881->3687|8950->3727|8980->3728|9025->3744|9055->3745|9090->3752|9288->3921|9318->3922|9355->3931|9520->4068|9549->4069|9582->4074|9611->4075|9642->4078|9673->4081|9702->4082|9731->4083
                  LINES: 14->1|20->5|23->6|23->6|23->6|23->6|24->7|24->7|24->7|24->7|25->8|25->8|26->9|29->12|30->13|36->19|36->19|36->19|36->19|40->23|40->23|40->23|40->23|41->24|41->24|41->24|42->25|43->26|43->26|43->26|43->26|43->26|46->29|46->29|47->30|48->31|49->32|53->36|54->37|55->38|56->39|56->39|57->40|57->40|57->40|58->41|58->41|58->41|59->42|61->44|61->44|61->44|61->44|61->44|62->45|62->45|62->45|62->45|63->46|63->46|64->47|65->48|65->48|66->49|67->50|67->50|68->51|68->51|69->52|69->52|70->53|70->53|70->53|71->54|73->56|73->56|74->57|74->57|74->57|75->58|76->59|76->59|78->61|78->61|80->63|80->63|81->64|82->65|82->65|83->66|84->67|84->67|85->68|85->68|85->68|85->68|85->68|86->69|87->70|87->70|87->70|87->70|88->71|89->72|89->72|90->73|90->73|91->74|91->74|92->75|93->76|93->76|95->78|95->78|96->79|96->79|96->79|97->80|97->80|97->80|97->80|97->80|97->80|98->81|99->82|99->82|100->83|101->84|101->84|102->85|103->86|103->86|104->87|104->87|105->88|105->88|107->90|107->90|107->90|108->91|108->91|108->91|108->91|109->92|109->92|110->93|111->94|111->94|112->95|113->96|113->96|115->98|115->98|115->98|116->99|118->101|118->101|120->103|120->103|120->103|121->104|123->106|123->106|123->106|124->107|124->107|124->107|124->107|124->107|125->108|125->108|126->109|130->113|130->113|131->114|135->118|135->118|136->119|136->119|137->120|138->121|138->121|139->122
                  -- GENERATED --
              */
          