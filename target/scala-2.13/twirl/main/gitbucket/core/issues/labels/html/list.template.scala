
package gitbucket.core.issues.labels.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object list extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[List[gitbucket.core.model.Label],Map[String, Int],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(labels: List[gitbucket.core.model.Label],
  counts: Map[String, Int],
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  hasWritePermission: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*5.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*6.2*/gitbucket/*6.11*/.core.html.main(s"Labels - ${repository.owner}/${repository.name}")/*6.78*/{_display_(Seq[Any](format.raw/*6.79*/("""
  """),_display_(/*7.4*/gitbucket/*7.13*/.core.html.menu("labels", repository)/*7.50*/{_display_(Seq[Any](format.raw/*7.51*/("""
    """),_display_(if(context.loginAccount.isDefined)/*8.40*/{_display_(Seq[Any](format.raw/*8.41*/("""
      """),format.raw/*9.7*/("""<div class="pull-right" style="margin-bottom: 10px;">
        <a class="btn btn-success" href="javascript:void(0);" id="new-label-button">New label</a>
      </div>
    """)))} else {null} ),format.raw/*12.6*/("""
    """),format.raw/*13.5*/("""<table class="table table-bordered table-hover table-issues" id="new-label-table" style="display: none;">
      <tr><td></td></tr>
    </table>
    <table class="table table-bordered table-hover table-issues">
      <thead>
        <tr id="label-row-header">
          <th>"""),_display_(/*19.16*/labels/*19.22*/.size),format.raw/*19.27*/(""" """),format.raw/*19.28*/("""labels</th>
        </tr>
      </thead>
      <tbody>
        """),_display_(/*23.10*/labels/*23.16*/.map/*23.20*/ { label =>_display_(Seq[Any](format.raw/*23.31*/("""
          """),_display_(/*24.12*/gitbucket/*24.21*/.core.issues.labels.html.label(label, counts, repository, hasWritePermission)),format.raw/*24.98*/("""
        """)))}),format.raw/*25.10*/("""
        """),_display_(if(labels.isEmpty)/*26.28*/{_display_(Seq[Any](format.raw/*26.29*/("""
          """),format.raw/*27.11*/("""<tr>
            <td style="padding: 20px; background-color: #eee; text-align: center;">
              No labels to show.
              """),_display_(if(hasWritePermission)/*30.38*/{_display_(Seq[Any](format.raw/*30.39*/("""
                """),format.raw/*31.17*/("""Click on the "New Label" button above to create one.
              """)))} else {null} ),format.raw/*32.16*/("""
            """),format.raw/*33.13*/("""</td>
          </tr>
        """)))} else {null} ),format.raw/*35.10*/("""
      """),format.raw/*36.7*/("""</tbody>
    </table>
  """)))}),format.raw/*38.4*/("""
""")))}),format.raw/*39.2*/("""
"""),format.raw/*40.1*/("""<script>
$(function()"""),format.raw/*41.13*/("""{"""),format.raw/*41.14*/("""
  """),format.raw/*42.3*/("""$('#new-label-button').click(function(e)"""),format.raw/*42.43*/("""{"""),format.raw/*42.44*/("""
    """),format.raw/*43.5*/("""if($('#edit-label-area-new').length != 0)"""),format.raw/*43.46*/("""{"""),format.raw/*43.47*/("""
      """),format.raw/*44.7*/("""$('div#edit-label-area-new').remove();
      $('#new-label-table').hide();
    """),format.raw/*46.5*/("""}"""),format.raw/*46.6*/(""" """),format.raw/*46.7*/("""else """),format.raw/*46.12*/("""{"""),format.raw/*46.13*/("""
      """),format.raw/*47.7*/("""$.get('"""),_display_(/*47.15*/helpers/*47.22*/.url(repository)),format.raw/*47.38*/("""/issues/labels/new',
        function(data)"""),format.raw/*48.23*/("""{"""),format.raw/*48.24*/("""
          """),format.raw/*49.11*/("""$('#new-label-table').show().find('tr td').append(data);
        """),format.raw/*50.9*/("""}"""),format.raw/*50.10*/("""
      """),format.raw/*51.7*/(""");
    """),format.raw/*52.5*/("""}"""),format.raw/*52.6*/("""
  """),format.raw/*53.3*/("""}"""),format.raw/*53.4*/(""");
"""),format.raw/*54.1*/("""}"""),format.raw/*54.2*/(""");

function deleteLabel(labelId)"""),format.raw/*56.30*/("""{"""),format.raw/*56.31*/("""
  """),format.raw/*57.3*/("""if(confirm('Once you delete this label, there is no going back.\nAre you sure?'))"""),format.raw/*57.84*/("""{"""),format.raw/*57.85*/("""
    """),format.raw/*58.5*/("""$.post('"""),_display_(/*58.14*/helpers/*58.21*/.url(repository)),format.raw/*58.37*/("""/issues/labels/' + labelId + '/delete', function()"""),format.raw/*58.87*/("""{"""),format.raw/*58.88*/("""
      """),format.raw/*59.7*/("""$('tr#label-row-' + labelId).remove();
    """),format.raw/*60.5*/("""}"""),format.raw/*60.6*/(""");
  """),format.raw/*61.3*/("""}"""),format.raw/*61.4*/("""
"""),format.raw/*62.1*/("""}"""),format.raw/*62.2*/("""

"""),format.raw/*64.1*/("""function editLabel(labelId)"""),format.raw/*64.28*/("""{"""),format.raw/*64.29*/("""
  """),format.raw/*65.3*/("""$.get('"""),_display_(/*65.11*/helpers/*65.18*/.url(repository)),format.raw/*65.34*/("""/issues/labels/' + labelId + '/edit',
    function(data)"""),format.raw/*66.19*/("""{"""),format.raw/*66.20*/("""
      """),format.raw/*67.7*/("""$('#label-' + labelId).hide().parent().append(data);
    """),format.raw/*68.5*/("""}"""),format.raw/*68.6*/("""
  """),format.raw/*69.3*/(""");
"""),format.raw/*70.1*/("""}"""),format.raw/*70.2*/("""
"""),format.raw/*71.1*/("""</script>
"""))
      }
    }
  }

  def render(labels:List[gitbucket.core.model.Label],counts:Map[String, Int],repository:gitbucket.core.service.RepositoryService.RepositoryInfo,hasWritePermission:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(labels,counts,repository,hasWritePermission)(context)

  def f:((List[gitbucket.core.model.Label],Map[String, Int],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (labels,counts,repository,hasWritePermission) => (context) => apply(labels,counts,repository,hasWritePermission)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/issues/labels/list.scala.html
                  HASH: c62d2fcfe9434484130fc8b822685d66fa0a2cd7
                  MATRIX: 729->1|1027->228|1090->264|1107->273|1182->340|1220->341|1249->345|1266->354|1311->391|1349->392|1415->432|1453->433|1486->440|1699->610|1731->615|2032->889|2047->895|2073->900|2102->901|2193->965|2208->971|2221->975|2270->986|2309->998|2327->1007|2425->1084|2466->1094|2521->1122|2560->1123|2599->1134|2785->1293|2824->1294|2869->1311|2981->1379|3022->1392|3097->1423|3131->1430|3186->1455|3218->1457|3246->1458|3295->1479|3324->1480|3354->1483|3422->1523|3451->1524|3483->1529|3552->1570|3581->1571|3615->1578|3721->1657|3749->1658|3777->1659|3810->1664|3839->1665|3873->1672|3908->1680|3924->1687|3961->1703|4032->1746|4061->1747|4100->1758|4192->1823|4221->1824|4255->1831|4289->1838|4317->1839|4347->1842|4375->1843|4405->1846|4433->1847|4494->1880|4523->1881|4553->1884|4662->1965|4691->1966|4723->1971|4759->1980|4775->1987|4812->2003|4890->2053|4919->2054|4953->2061|5023->2104|5051->2105|5083->2110|5111->2111|5139->2112|5167->2113|5196->2115|5251->2142|5280->2143|5310->2146|5345->2154|5361->2161|5398->2177|5482->2233|5511->2234|5545->2241|5629->2298|5657->2299|5687->2302|5717->2305|5745->2306|5773->2307
                  LINES: 14->1|20->5|23->6|23->6|23->6|23->6|24->7|24->7|24->7|24->7|25->8|25->8|26->9|29->12|30->13|36->19|36->19|36->19|36->19|40->23|40->23|40->23|40->23|41->24|41->24|41->24|42->25|43->26|43->26|44->27|47->30|47->30|48->31|49->32|50->33|52->35|53->36|55->38|56->39|57->40|58->41|58->41|59->42|59->42|59->42|60->43|60->43|60->43|61->44|63->46|63->46|63->46|63->46|63->46|64->47|64->47|64->47|64->47|65->48|65->48|66->49|67->50|67->50|68->51|69->52|69->52|70->53|70->53|71->54|71->54|73->56|73->56|74->57|74->57|74->57|75->58|75->58|75->58|75->58|75->58|75->58|76->59|77->60|77->60|78->61|78->61|79->62|79->62|81->64|81->64|81->64|82->65|82->65|82->65|82->65|83->66|83->66|84->67|85->68|85->68|86->69|87->70|87->70|88->71
                  -- GENERATED --
              */
          