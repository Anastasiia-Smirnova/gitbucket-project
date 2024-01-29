
package gitbucket.core.issues.priorities.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Option[gitbucket.core.model.Priority],gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(priority: Option[gitbucket.core.model.Priority],
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*4.2*/defining(priority.map(_.priorityId).getOrElse("new"))/*4.55*/{ priorityId =>_display_(Seq[Any](format.raw/*4.70*/("""
"""),format.raw/*5.1*/("""<div id="edit-priority-area-"""),_display_(/*5.30*/priorityId),format.raw/*5.40*/("""">
  <form class="form-inline" autocomplete="off">
    <input type="text" id="priorityName-"""),_display_(/*7.42*/priorityId),format.raw/*7.52*/("""" style="width: 200px; float: left; margin-right: 4px;" class="form-control input-sm" value=""""),_display_(/*7.146*/priority/*7.154*/.map(_.priorityName)),format.raw/*7.174*/("""""""),_display_(if(priorityId == "new")/*7.199*/{_display_(Seq[Any](format.raw/*7.200*/(""" """),format.raw/*7.201*/("""placeholder="New priority name"""")))} else {null} ),format.raw/*7.233*/("""/>
    <div id="priority-color-"""),_display_(/*8.30*/priorityId),format.raw/*8.40*/("""" class="input-group color bscp" data-color="#"""),_display_(/*8.87*/priority/*8.95*/.map(_.color).getOrElse("888888")),format.raw/*8.128*/("""" data-color-format="hex" style="width: 100px; float: left;">
      <input type="text" class="form-control input-sm" id="priorityColor-"""),_display_(/*9.75*/priorityId),format.raw/*9.85*/("""" value="#"""),_display_(/*9.96*/priority/*9.104*/.map(_.color).getOrElse("888888")),format.raw/*9.137*/("""" style="width: 100px;">
      <span class="input-group-addon"><i style="background-color: #"""),_display_(/*10.69*/priority/*10.77*/.map(_.color).getOrElse("888888")),format.raw/*10.110*/(""";"></i></span>
    </div>
    <script>
    $('div#priority-color-"""),_display_(/*13.28*/priorityId),format.raw/*13.38*/("""').colorpicker("""),format.raw/*13.53*/("""{"""),format.raw/*13.54*/("""format: "hex""""),format.raw/*13.67*/("""}"""),format.raw/*13.68*/(""");
    </script>
    <input type="text" id="description-"""),_display_(/*15.41*/priorityId),format.raw/*15.51*/("""" style="width: 500px; float: left; margin-left: 4px;" class="form-control input-sm" value=""""),_display_(/*15.144*/priority/*15.152*/.flatMap(_.description).getOrElse("")),format.raw/*15.189*/("""" placeholder="Description..." />
    <span class="pull-right">
      <span id="priority-error-"""),_display_(/*17.33*/priorityId),format.raw/*17.43*/("""" class="error"></span>
      <input type="button" id="cancel-"""),_display_(/*18.40*/priorityId),format.raw/*18.50*/("""" class="btn btn-sm btn-default priority-edit-cancel" value="Cancel">
      <input type="button" id="submit-"""),_display_(/*19.40*/priorityId),format.raw/*19.50*/("""" class="btn btn-sm btn-success" style="margin-bottom: 0px;" value=""""),_display_(/*19.119*/(if(priorityId == "new") "Create priority"  else "Save changes")),format.raw/*19.183*/(""""/>
    </span>
  </form>
</div>
<script>
$(function()"""),format.raw/*24.13*/("""{"""),format.raw/*24.14*/("""
  """),format.raw/*25.3*/("""$('#submit-"""),_display_(/*25.15*/priorityId),format.raw/*25.25*/("""').click(function(e)"""),format.raw/*25.45*/("""{"""),format.raw/*25.46*/("""
    """),format.raw/*26.5*/("""$.post('"""),_display_(/*26.14*/helpers/*26.21*/.url(repository)),format.raw/*26.37*/("""/issues/priorities/"""),_display_(/*26.57*/{if(priorityId == "new") "new" else s"$priorityId/edit"}),format.raw/*26.113*/("""', """),format.raw/*26.116*/("""{"""),format.raw/*26.117*/("""
      """),format.raw/*27.7*/("""'priorityName' : $('#priorityName-"""),_display_(/*27.42*/priorityId),format.raw/*27.52*/("""').val(),
      'description' : $('#description-"""),_display_(/*28.40*/priorityId),format.raw/*28.50*/("""').val(),
      'priorityColor': $('#priorityColor-"""),_display_(/*29.43*/priorityId),format.raw/*29.53*/("""').val()
    """),format.raw/*30.5*/("""}"""),format.raw/*30.6*/(""", function(data, status)"""),format.raw/*30.30*/("""{"""),format.raw/*30.31*/("""
      """),format.raw/*31.7*/("""$('div#edit-priority-area-"""),_display_(/*31.34*/priorityId),format.raw/*31.44*/("""').remove();
      """),_display_(if(priorityId == "new")/*32.31*/{_display_(Seq[Any](format.raw/*32.32*/("""
        """),format.raw/*33.9*/("""$('#new-priority-table').hide();
        // Insert row into the top of table
        $('#priorities-table tbody').append(data);
      """)))}else/*36.14*/{_display_(Seq[Any](format.raw/*36.15*/("""
        """),format.raw/*37.9*/("""// Replace table row
        $('#priority-row-"""),_display_(/*38.27*/priorityId),format.raw/*38.37*/("""').after(data).remove();
      """)))}),format.raw/*39.8*/("""
      """),format.raw/*40.7*/("""$('#priority-no-priorities').hide();
      updatePriorityCount();
    """),format.raw/*42.5*/("""}"""),format.raw/*42.6*/(""").fail(function(xhr, status, error)"""),format.raw/*42.41*/("""{"""),format.raw/*42.42*/("""
      """),format.raw/*43.7*/("""var errors = JSON.parse(xhr.responseText);
      if(errors.priorityName)"""),format.raw/*44.30*/("""{"""),format.raw/*44.31*/("""
        """),format.raw/*45.9*/("""$('span#priority-error-"""),_display_(/*45.33*/priorityId),format.raw/*45.43*/("""').text(errors.priorityName);
      """),format.raw/*46.7*/("""}"""),format.raw/*46.8*/(""" """),format.raw/*46.9*/("""else if(errors.description)"""),format.raw/*46.36*/("""{"""),format.raw/*46.37*/("""
        """),format.raw/*47.9*/("""$('span#priority-error-"""),_display_(/*47.33*/priorityId),format.raw/*47.43*/("""').text(errors.description);
      """),format.raw/*48.7*/("""}"""),format.raw/*48.8*/(""" """),format.raw/*48.9*/("""else if(errors.priorityColor)"""),format.raw/*48.38*/("""{"""),format.raw/*48.39*/("""
        """),format.raw/*49.9*/("""$('span#priority-error-"""),_display_(/*49.33*/priorityId),format.raw/*49.43*/("""').text(errors.priorityColor);
      """),format.raw/*50.7*/("""}"""),format.raw/*50.8*/(""" """),format.raw/*50.9*/("""else """),format.raw/*50.14*/("""{"""),format.raw/*50.15*/("""
        """),format.raw/*51.9*/("""$('span#priority-error-"""),_display_(/*51.33*/priorityId),format.raw/*51.43*/("""').text('error');
      """),format.raw/*52.7*/("""}"""),format.raw/*52.8*/("""
    """),format.raw/*53.5*/("""}"""),format.raw/*53.6*/(""");
    return false;
  """),format.raw/*55.3*/("""}"""),format.raw/*55.4*/(""");

  $('#cancel-"""),_display_(/*57.15*/priorityId),format.raw/*57.25*/("""').click(function(e)"""),format.raw/*57.45*/("""{"""),format.raw/*57.46*/("""
    """),format.raw/*58.5*/("""$('div#edit-priority-area-"""),_display_(/*58.32*/priorityId),format.raw/*58.42*/("""').remove();
    """),_display_(if(priorityId == "new")/*59.29*/{_display_(Seq[Any](format.raw/*59.30*/("""
      """),format.raw/*60.7*/("""$('#new-priority-table').hide();
    """)))}else/*61.12*/{_display_(Seq[Any](format.raw/*61.13*/("""
      """),format.raw/*62.7*/("""$('#priority-"""),_display_(/*62.21*/priorityId),format.raw/*62.31*/("""').show();
    """)))}),format.raw/*63.6*/("""
  """),format.raw/*64.3*/("""}"""),format.raw/*64.4*/(""");
"""),format.raw/*65.1*/("""}"""),format.raw/*65.2*/(""");
</script>
""")))}),format.raw/*67.2*/("""
"""))
      }
    }
  }

  def render(priority:Option[gitbucket.core.model.Priority],repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(priority,repository)(context)

  def f:((Option[gitbucket.core.model.Priority],gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (priority,repository) => (context) => apply(priority,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/issues/priorities/edit.scala.html
                  HASH: 82c0fae4de620bf15ff68dbb17fdd1bf5812b78f
                  MATRIX: 713->1|959->176|1022->212|1083->265|1135->280|1162->281|1217->310|1247->320|1365->412|1395->422|1516->516|1533->524|1574->544|1626->569|1665->570|1694->571|1770->603|1828->635|1858->645|1931->692|1947->700|2001->733|2163->869|2193->879|2230->890|2247->898|2301->931|2421->1024|2438->1032|2493->1065|2586->1131|2617->1141|2660->1156|2689->1157|2730->1170|2759->1171|2843->1228|2874->1238|2995->1331|3013->1339|3072->1376|3195->1472|3226->1482|3316->1545|3347->1555|3483->1664|3514->1674|3611->1743|3697->1807|3779->1861|3808->1862|3838->1865|3877->1877|3908->1887|3956->1907|3985->1908|4017->1913|4053->1922|4069->1929|4106->1945|4153->1965|4231->2021|4263->2024|4293->2025|4327->2032|4389->2067|4420->2077|4496->2126|4527->2136|4606->2188|4637->2198|4677->2211|4705->2212|4757->2236|4786->2237|4820->2244|4874->2271|4905->2281|4975->2324|5014->2325|5050->2334|5208->2475|5247->2476|5283->2485|5357->2532|5388->2542|5450->2574|5484->2581|5581->2651|5609->2652|5672->2687|5701->2688|5735->2695|5835->2767|5864->2768|5900->2777|5951->2801|5982->2811|6045->2847|6073->2848|6101->2849|6156->2876|6185->2877|6221->2886|6272->2910|6303->2920|6365->2955|6393->2956|6421->2957|6478->2986|6507->2987|6543->2996|6594->3020|6625->3030|6689->3067|6717->3068|6745->3069|6778->3074|6807->3075|6843->3084|6894->3108|6925->3118|6976->3142|7004->3143|7036->3148|7064->3149|7114->3172|7142->3173|7187->3191|7218->3201|7266->3221|7295->3222|7327->3227|7381->3254|7412->3264|7480->3305|7519->3306|7553->3313|7614->3357|7653->3358|7687->3365|7728->3379|7759->3389|7805->3405|7835->3408|7863->3409|7893->3412|7921->3413|7965->3427
                  LINES: 14->1|18->3|21->4|21->4|21->4|22->5|22->5|22->5|24->7|24->7|24->7|24->7|24->7|24->7|24->7|24->7|24->7|25->8|25->8|25->8|25->8|25->8|26->9|26->9|26->9|26->9|26->9|27->10|27->10|27->10|30->13|30->13|30->13|30->13|30->13|30->13|32->15|32->15|32->15|32->15|32->15|34->17|34->17|35->18|35->18|36->19|36->19|36->19|36->19|41->24|41->24|42->25|42->25|42->25|42->25|42->25|43->26|43->26|43->26|43->26|43->26|43->26|43->26|43->26|44->27|44->27|44->27|45->28|45->28|46->29|46->29|47->30|47->30|47->30|47->30|48->31|48->31|48->31|49->32|49->32|50->33|53->36|53->36|54->37|55->38|55->38|56->39|57->40|59->42|59->42|59->42|59->42|60->43|61->44|61->44|62->45|62->45|62->45|63->46|63->46|63->46|63->46|63->46|64->47|64->47|64->47|65->48|65->48|65->48|65->48|65->48|66->49|66->49|66->49|67->50|67->50|67->50|67->50|67->50|68->51|68->51|68->51|69->52|69->52|70->53|70->53|72->55|72->55|74->57|74->57|74->57|74->57|75->58|75->58|75->58|76->59|76->59|77->60|78->61|78->61|79->62|79->62|79->62|80->63|81->64|81->64|82->65|82->65|84->67
                  -- GENERATED --
              */
          