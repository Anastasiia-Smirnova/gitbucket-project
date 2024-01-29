
package gitbucket.core.issues.labels.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Option[gitbucket.core.model.Label],gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(label: Option[gitbucket.core.model.Label],
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*4.2*/defining(label.map(_.labelId).getOrElse("new"))/*4.49*/{ labelId =>_display_(Seq[Any](format.raw/*4.61*/("""
"""),format.raw/*5.1*/("""<div id="edit-label-area-"""),_display_(/*5.27*/labelId),format.raw/*5.34*/("""">
  <form class="form-inline" autocomplete="off">
    <input type="text" id="labelName-"""),_display_(/*7.39*/labelId),format.raw/*7.46*/("""" style="width: 300px; float: left; margin-right: 4px;" class="form-control input-sm" value=""""),_display_(/*7.140*/label/*7.145*/.map(_.labelName)),format.raw/*7.162*/("""""""),_display_(if(labelId == "new")/*7.184*/{_display_(Seq[Any](format.raw/*7.185*/(""" """),format.raw/*7.186*/("""placeholder="New label name"""")))} else {null} ),format.raw/*7.215*/("""/>
    <div id="label-color-"""),_display_(/*8.27*/labelId),format.raw/*8.34*/("""" class="input-group color bscp" data-color="#"""),_display_(/*8.81*/label/*8.86*/.map(_.color).getOrElse("888888")),format.raw/*8.119*/("""" data-color-format="hex" style="width: 100px; float: left;">
      <input type="text" class="form-control input-sm" id="labelColor-"""),_display_(/*9.72*/labelId),format.raw/*9.79*/("""" value="#"""),_display_(/*9.90*/label/*9.95*/.map(_.color).getOrElse("888888")),format.raw/*9.128*/("""" style="width: 100px;">
      <span class="input-group-addon"><i style="background-color: #"""),_display_(/*10.69*/label/*10.74*/.map(_.color).getOrElse("888888")),format.raw/*10.107*/(""";"></i></span>
    </div>
    <script>
    $('div#label-color-"""),_display_(/*13.25*/labelId),format.raw/*13.32*/("""').colorpicker("""),format.raw/*13.47*/("""{"""),format.raw/*13.48*/("""format: "hex""""),format.raw/*13.61*/("""}"""),format.raw/*13.62*/(""");
    </script>
    <span class="pull-right">
      <span id="label-error-"""),_display_(/*16.30*/labelId),format.raw/*16.37*/("""" class="error"></span>
      <input type="button" id="cancel-"""),_display_(/*17.40*/labelId),format.raw/*17.47*/("""" class="btn btn-sm btn-default label-edit-cancel" value="Cancel">
      <input type="button" id="submit-"""),_display_(/*18.40*/labelId),format.raw/*18.47*/("""" class="btn btn-sm btn-success" style="margin-bottom: 0px;" value=""""),_display_(/*18.116*/(if(labelId == "new") "Create label"  else "Save changes")),format.raw/*18.174*/(""""/>
    </span>
  </form>
</div>
<script>
$(function()"""),format.raw/*23.13*/("""{"""),format.raw/*23.14*/("""
  """),format.raw/*24.3*/("""$('#submit-"""),_display_(/*24.15*/labelId),format.raw/*24.22*/("""').click(function(e)"""),format.raw/*24.42*/("""{"""),format.raw/*24.43*/("""
    """),format.raw/*25.5*/("""$.post('"""),_display_(/*25.14*/helpers/*25.21*/.url(repository)),format.raw/*25.37*/("""/issues/labels/"""),_display_(/*25.53*/{if(labelId == "new") "new" else s"$labelId/edit"}),format.raw/*25.103*/("""', """),format.raw/*25.106*/("""{"""),format.raw/*25.107*/("""
      """),format.raw/*26.7*/("""'labelName' : $('#labelName-"""),_display_(/*26.36*/labelId),format.raw/*26.43*/("""').val(),
      'labelColor': $('#labelColor-"""),_display_(/*27.37*/labelId),format.raw/*27.44*/("""').val()
    """),format.raw/*28.5*/("""}"""),format.raw/*28.6*/(""", function(data, status)"""),format.raw/*28.30*/("""{"""),format.raw/*28.31*/("""
      """),format.raw/*29.7*/("""$('div#edit-label-area-"""),_display_(/*29.31*/labelId),format.raw/*29.38*/("""').remove();
      """),_display_(if(labelId == "new")/*30.28*/{_display_(Seq[Any](format.raw/*30.29*/("""
        """),format.raw/*31.9*/("""$('#new-label-table').hide();
        // Insert row into the top of table
        $('#label-row-header').after(data);
      """)))}else/*34.14*/{_display_(Seq[Any](format.raw/*34.15*/("""
        """),format.raw/*35.9*/("""// Replace table row
        $('#label-row-"""),_display_(/*36.24*/labelId),format.raw/*36.31*/("""').after(data).remove();
      """)))}),format.raw/*37.8*/("""
    """),format.raw/*38.5*/("""}"""),format.raw/*38.6*/(""").fail(function(xhr, status, error)"""),format.raw/*38.41*/("""{"""),format.raw/*38.42*/("""
      """),format.raw/*39.7*/("""var errors = JSON.parse(xhr.responseText);
      if(errors.labelName)"""),format.raw/*40.27*/("""{"""),format.raw/*40.28*/("""
        """),format.raw/*41.9*/("""$('span#label-error-"""),_display_(/*41.30*/labelId),format.raw/*41.37*/("""').text(errors.labelName);
      """),format.raw/*42.7*/("""}"""),format.raw/*42.8*/(""" """),format.raw/*42.9*/("""else if(errors.labelColor)"""),format.raw/*42.35*/("""{"""),format.raw/*42.36*/("""
        """),format.raw/*43.9*/("""$('span#label-error-"""),_display_(/*43.30*/labelId),format.raw/*43.37*/("""').text(errors.labelColor);
      """),format.raw/*44.7*/("""}"""),format.raw/*44.8*/(""" """),format.raw/*44.9*/("""else """),format.raw/*44.14*/("""{"""),format.raw/*44.15*/("""
        """),format.raw/*45.9*/("""$('span#label-error-"""),_display_(/*45.30*/labelId),format.raw/*45.37*/("""').text('error');
      """),format.raw/*46.7*/("""}"""),format.raw/*46.8*/("""
    """),format.raw/*47.5*/("""}"""),format.raw/*47.6*/(""");
    return false;
  """),format.raw/*49.3*/("""}"""),format.raw/*49.4*/(""");

  $('#cancel-"""),_display_(/*51.15*/labelId),format.raw/*51.22*/("""').click(function(e)"""),format.raw/*51.42*/("""{"""),format.raw/*51.43*/("""
    """),format.raw/*52.5*/("""$('div#edit-label-area-"""),_display_(/*52.29*/labelId),format.raw/*52.36*/("""').remove();
    """),_display_(if(labelId == "new")/*53.26*/{_display_(Seq[Any](format.raw/*53.27*/("""
      """),format.raw/*54.7*/("""$('#new-label-table').hide();
    """)))}else/*55.12*/{_display_(Seq[Any](format.raw/*55.13*/("""
      """),format.raw/*56.7*/("""$('#label-"""),_display_(/*56.18*/labelId),format.raw/*56.25*/("""').show();
    """)))}),format.raw/*57.6*/("""
  """),format.raw/*58.3*/("""}"""),format.raw/*58.4*/(""");
"""),format.raw/*59.1*/("""}"""),format.raw/*59.2*/(""");
</script>
""")))}),format.raw/*61.2*/("""
"""))
      }
    }
  }

  def render(label:Option[gitbucket.core.model.Label],repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(label,repository)(context)

  def f:((Option[gitbucket.core.model.Label],gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (label,repository) => (context) => apply(label,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/issues/labels/edit.scala.html
                  HASH: 822c408815f4c58a1aec276a839aac6133a105a8
                  MATRIX: 706->1|946->170|1009->206|1064->253|1113->265|1140->266|1192->292|1219->299|1334->388|1361->395|1482->489|1496->494|1534->511|1583->533|1622->534|1651->535|1724->564|1779->593|1806->600|1879->647|1892->652|1946->685|2105->818|2132->825|2169->836|2182->841|2236->874|2356->967|2370->972|2425->1005|2515->1068|2543->1075|2586->1090|2615->1091|2656->1104|2685->1105|2788->1181|2816->1188|2906->1251|2934->1258|3067->1364|3095->1371|3192->1440|3272->1498|3354->1552|3383->1553|3413->1556|3452->1568|3480->1575|3528->1595|3557->1596|3589->1601|3625->1610|3641->1617|3678->1633|3721->1649|3793->1699|3825->1702|3855->1703|3889->1710|3945->1739|3973->1746|4046->1792|4074->1799|4114->1812|4142->1813|4194->1837|4223->1838|4257->1845|4308->1869|4336->1876|4403->1916|4442->1917|4478->1926|4626->2057|4665->2058|4701->2067|4772->2111|4800->2118|4862->2150|4894->2155|4922->2156|4985->2191|5014->2192|5048->2199|5145->2268|5174->2269|5210->2278|5258->2299|5286->2306|5346->2339|5374->2340|5402->2341|5456->2367|5485->2368|5521->2377|5569->2398|5597->2405|5658->2439|5686->2440|5714->2441|5747->2446|5776->2447|5812->2456|5860->2477|5888->2484|5939->2508|5967->2509|5999->2514|6027->2515|6077->2538|6105->2539|6150->2557|6178->2564|6226->2584|6255->2585|6287->2590|6338->2614|6366->2621|6431->2659|6470->2660|6504->2667|6562->2708|6601->2709|6635->2716|6673->2727|6701->2734|6747->2750|6777->2753|6805->2754|6835->2757|6863->2758|6907->2772
                  LINES: 14->1|18->3|21->4|21->4|21->4|22->5|22->5|22->5|24->7|24->7|24->7|24->7|24->7|24->7|24->7|24->7|24->7|25->8|25->8|25->8|25->8|25->8|26->9|26->9|26->9|26->9|26->9|27->10|27->10|27->10|30->13|30->13|30->13|30->13|30->13|30->13|33->16|33->16|34->17|34->17|35->18|35->18|35->18|35->18|40->23|40->23|41->24|41->24|41->24|41->24|41->24|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|43->26|43->26|43->26|44->27|44->27|45->28|45->28|45->28|45->28|46->29|46->29|46->29|47->30|47->30|48->31|51->34|51->34|52->35|53->36|53->36|54->37|55->38|55->38|55->38|55->38|56->39|57->40|57->40|58->41|58->41|58->41|59->42|59->42|59->42|59->42|59->42|60->43|60->43|60->43|61->44|61->44|61->44|61->44|61->44|62->45|62->45|62->45|63->46|63->46|64->47|64->47|66->49|66->49|68->51|68->51|68->51|68->51|69->52|69->52|69->52|70->53|70->53|71->54|72->55|72->55|73->56|73->56|73->56|74->57|75->58|75->58|76->59|76->59|78->61
                  -- GENERATED --
              */
          