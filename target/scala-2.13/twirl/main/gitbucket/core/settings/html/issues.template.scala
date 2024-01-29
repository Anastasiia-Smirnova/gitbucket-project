
package gitbucket.core.settings.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object issues extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[List[gitbucket.core.model.CustomField],gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(customFields: List[gitbucket.core.model.CustomField],
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*4.2*/gitbucket/*4.11*/.core.html.main("Issues", Some(repository))/*4.54*/ {_display_(Seq[Any](format.raw/*4.56*/("""
  """),_display_(/*5.4*/gitbucket/*5.13*/.core.html.menu("settings", repository)/*5.52*/ {_display_(Seq[Any](format.raw/*5.54*/("""
    """),_display_(/*6.6*/gitbucket/*6.15*/.core.settings.html.menu("issues", repository)/*6.61*/ {_display_(Seq[Any](format.raw/*6.63*/("""
      """),format.raw/*7.7*/("""<div class="pull-right" style="margin-bottom: 10px;">
        <a class="btn btn-success" href="javascript:void(0);" id="new-field-button">New field</a>
      </div>
      <table class="table table-bordered table-hover table-issues" id="new-field-table" style="display: none;">
        <tr><td></td></tr>
      </table>
      <table class="table table-bordered table-hover">
        <tr id="field-row-header">
          <th>"""),_display_(/*15.16*/customFields/*15.28*/.size),format.raw/*15.33*/(""" """),format.raw/*15.34*/("""custom fields</th>
        </tr>
        """),_display_(/*17.10*/customFields/*17.22*/.map/*17.26*/ { customField =>_display_(Seq[Any](format.raw/*17.43*/("""
          """),_display_(/*18.12*/gitbucket/*18.21*/.core.settings.html.issuesfield(customField)),format.raw/*18.65*/("""
        """)))}),format.raw/*19.10*/("""
      """),format.raw/*20.7*/("""</table>
    """)))}),format.raw/*21.6*/("""
  """)))}),format.raw/*22.4*/("""
""")))}),format.raw/*23.2*/("""
"""),format.raw/*24.1*/("""<script>
$(function()"""),format.raw/*25.13*/("""{"""),format.raw/*25.14*/("""
  """),format.raw/*26.3*/("""$('#new-field-button').click(function(e)"""),format.raw/*26.43*/("""{"""),format.raw/*26.44*/("""
    """),format.raw/*27.5*/("""if($('#edit-field-area-new').length != 0)"""),format.raw/*27.46*/("""{"""),format.raw/*27.47*/("""
      """),format.raw/*28.7*/("""$('div#edit-field-area-new').remove();
      $('#new-field-table').hide();
    """),format.raw/*30.5*/("""}"""),format.raw/*30.6*/(""" """),format.raw/*30.7*/("""else """),format.raw/*30.12*/("""{"""),format.raw/*30.13*/("""
      """),format.raw/*31.7*/("""$.get('"""),_display_(/*31.15*/helpers/*31.22*/.url(repository)),format.raw/*31.38*/("""/settings/issues/fields/new',
        function(data)"""),format.raw/*32.23*/("""{"""),format.raw/*32.24*/("""
          """),format.raw/*33.11*/("""$('#new-field-table').show().find('tr td').append(data);
        """),format.raw/*34.9*/("""}"""),format.raw/*34.10*/("""
      """),format.raw/*35.7*/(""");
    """),format.raw/*36.5*/("""}"""),format.raw/*36.6*/("""
  """),format.raw/*37.3*/("""}"""),format.raw/*37.4*/(""");
"""),format.raw/*38.1*/("""}"""),format.raw/*38.2*/(""");

function deleteField(fieldId)"""),format.raw/*40.30*/("""{"""),format.raw/*40.31*/("""
  """),format.raw/*41.3*/("""if(confirm('Once you delete this field, there is no going back.\nAre you sure?'))"""),format.raw/*41.84*/("""{"""),format.raw/*41.85*/("""
    """),format.raw/*42.5*/("""$.post('"""),_display_(/*42.14*/helpers/*42.21*/.url(repository)),format.raw/*42.37*/("""/settings/issues/fields/' + fieldId + '/delete', function()"""),format.raw/*42.96*/("""{"""),format.raw/*42.97*/("""
      """),format.raw/*43.7*/("""$('tr#field-row-' + fieldId).remove();
    """),format.raw/*44.5*/("""}"""),format.raw/*44.6*/(""");
  """),format.raw/*45.3*/("""}"""),format.raw/*45.4*/("""
"""),format.raw/*46.1*/("""}"""),format.raw/*46.2*/("""

"""),format.raw/*48.1*/("""function editField(fieldId)"""),format.raw/*48.28*/("""{"""),format.raw/*48.29*/("""
  """),format.raw/*49.3*/("""$.get('"""),_display_(/*49.11*/helpers/*49.18*/.url(repository)),format.raw/*49.34*/("""/settings/issues/fields/' + fieldId + '/edit',
    function(data)"""),format.raw/*50.19*/("""{"""),format.raw/*50.20*/("""
      """),format.raw/*51.7*/("""$('#field-' + fieldId).hide().parent().append(data);
    """),format.raw/*52.5*/("""}"""),format.raw/*52.6*/("""
  """),format.raw/*53.3*/(""");
"""),format.raw/*54.1*/("""}"""),format.raw/*54.2*/("""
"""),format.raw/*55.1*/("""</script>
"""))
      }
    }
  }

  def render(customFields:List[gitbucket.core.model.CustomField],repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(customFields,repository)(context)

  def f:((List[gitbucket.core.model.CustomField],gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (customFields,repository) => (context) => apply(customFields,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/settings/issues.scala.html
                  HASH: 375b0a6e1c3795d002215ae3a8912986077a3a5e
                  MATRIX: 707->1|958->181|1021->217|1038->226|1089->269|1128->271|1157->275|1174->284|1221->323|1260->325|1291->331|1308->340|1362->386|1401->388|1434->395|1885->819|1906->831|1932->836|1961->837|2030->879|2051->891|2064->895|2119->912|2158->924|2176->933|2241->977|2282->987|2316->994|2360->1008|2394->1012|2426->1014|2454->1015|2503->1036|2532->1037|2562->1040|2630->1080|2659->1081|2691->1086|2760->1127|2789->1128|2823->1135|2929->1214|2957->1215|2985->1216|3018->1221|3047->1222|3081->1229|3116->1237|3132->1244|3169->1260|3249->1312|3278->1313|3317->1324|3409->1389|3438->1390|3472->1397|3506->1404|3534->1405|3564->1408|3592->1409|3622->1412|3650->1413|3711->1446|3740->1447|3770->1450|3879->1531|3908->1532|3940->1537|3976->1546|3992->1553|4029->1569|4116->1628|4145->1629|4179->1636|4249->1679|4277->1680|4309->1685|4337->1686|4365->1687|4393->1688|4422->1690|4477->1717|4506->1718|4536->1721|4571->1729|4587->1736|4624->1752|4717->1817|4746->1818|4780->1825|4864->1882|4892->1883|4922->1886|4952->1889|4980->1890|5008->1891
                  LINES: 14->1|18->3|21->4|21->4|21->4|21->4|22->5|22->5|22->5|22->5|23->6|23->6|23->6|23->6|24->7|32->15|32->15|32->15|32->15|34->17|34->17|34->17|34->17|35->18|35->18|35->18|36->19|37->20|38->21|39->22|40->23|41->24|42->25|42->25|43->26|43->26|43->26|44->27|44->27|44->27|45->28|47->30|47->30|47->30|47->30|47->30|48->31|48->31|48->31|48->31|49->32|49->32|50->33|51->34|51->34|52->35|53->36|53->36|54->37|54->37|55->38|55->38|57->40|57->40|58->41|58->41|58->41|59->42|59->42|59->42|59->42|59->42|59->42|60->43|61->44|61->44|62->45|62->45|63->46|63->46|65->48|65->48|65->48|66->49|66->49|66->49|66->49|67->50|67->50|68->51|69->52|69->52|70->53|71->54|71->54|72->55
                  -- GENERATED --
              */
          