
package gitbucket.core.helper.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object attached extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[gitbucket.core.service.RepositoryService.RepositoryInfo,String,Boolean,Html,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  completionContext: String, generateScript: Boolean = true)(textarea: Html)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import gitbucket.core.util.FileUtil
/*4.2*/import gitbucket.core.view.helpers

def /*90.2*/dropzone/*90.10*/(clickable: Boolean, textareaId: Option[String]):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*90.62*/("""
  """),format.raw/*91.3*/("""url: '"""),_display_(/*91.10*/context/*91.17*/.path),format.raw/*91.22*/("""/upload/file/"""),_display_(/*91.36*/repository/*91.46*/.owner),format.raw/*91.52*/("""/"""),_display_(/*91.54*/repository/*91.64*/.name),format.raw/*91.69*/("""',
  maxFilesize: """),_display_(/*92.17*/{context.settings.upload.maxFileSize / 1024 / 1024}),format.raw/*92.68*/(""",
  timeout: """),_display_(/*93.13*/{context.settings.upload.timeout}),format.raw/*93.46*/(""",
  clickable: """),_display_(/*94.15*/clickable),format.raw/*94.24*/(""",
  previewTemplate: "<div class=\"dz-preview\">\n  <div class=\"dz-progress\"><span class=\"dz-upload\" data-dz-uploadprogress>Uploading your files...</span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>",
  success: function(file, id) """),format.raw/*96.31*/("""{"""),format.raw/*96.32*/("""
    """),format.raw/*97.5*/("""var attachFile = (file.type.match(/image\/.*/) ? '\n![' + file.name.split('.')[0] : '\n[' + file.name) +
        ']("""),_display_(/*98.13*/context/*98.20*/.baseUrl),format.raw/*98.28*/("""/"""),_display_(/*98.30*/repository/*98.40*/.owner),format.raw/*98.46*/("""/"""),_display_(/*98.48*/repository/*98.58*/.name),format.raw/*98.63*/("""/_attached/' + id + ')';
    $('#"""),_display_(/*99.10*/textareaId),format.raw/*99.20*/("""').val($('#"""),_display_(/*99.32*/textareaId),format.raw/*99.42*/("""').val() + attachFile);
    $(file.previewElement).prevAll('div.dz-preview').addBack().remove();
  """),format.raw/*101.3*/("""}"""),format.raw/*101.4*/("""
""")))};
Seq[Any](format.raw/*5.1*/("""<div class="muted attachable">
  """),_display_(/*6.4*/textarea),format.raw/*6.12*/("""
  """),format.raw/*7.3*/("""<div class="clickable">Attach images or documents by dragging &amp; dropping, or selecting them.</div>
</div>
"""),_display_(/*9.2*/defining("(id=\")([\\w\\-]*)(\")".r.findFirstMatchIn(textarea.body).map(_.group(2)))/*9.86*/{ textareaId =>_display_(Seq[Any](format.raw/*9.101*/("""
"""),format.raw/*10.1*/("""<script>
$(function()"""),format.raw/*11.13*/("""{"""),format.raw/*11.14*/("""
  """),_display_(/*12.4*/gitbucket/*12.13*/.core.plugin.PluginRegistry().getSuggestionProviders.map/*12.69*/ { provider =>_display_(Seq[Any](format.raw/*12.83*/("""
    """),_display_(if(provider.context.contains(completionContext))/*13.54*/{_display_(Seq[Any](format.raw/*13.55*/("""
      """),format.raw/*14.7*/("""var """),_display_(/*14.12*/provider/*14.20*/.id),format.raw/*14.23*/(""" """),format.raw/*14.24*/("""= """),_display_(/*14.27*/Html(helpers.json(provider.options(repository).map { case (value, label) =>
        Map("value" -> value, "label" -> label)
      }))),format.raw/*16.10*/(""";
      """),_display_(/*17.8*/Html(provider.additionalScript(repository))),format.raw/*17.51*/("""
    """)))} else {null} ),format.raw/*18.6*/("""
  """)))}),format.raw/*19.4*/("""
  """),format.raw/*20.3*/("""$('#"""),_display_(/*20.8*/textareaId),format.raw/*20.18*/("""').textcomplete([
    """),_display_(/*21.6*/gitbucket/*21.15*/.core.plugin.PluginRegistry().getSuggestionProviders.map/*21.71*/ { provider =>_display_(Seq[Any](format.raw/*21.85*/("""
      """),_display_(if(provider.context.contains(completionContext))/*22.56*/{_display_(Seq[Any](format.raw/*22.57*/("""
        """),format.raw/*23.9*/("""{"""),format.raw/*23.10*/("""
          """),format.raw/*24.11*/("""id: '"""),_display_(/*24.17*/{provider.id}),format.raw/*24.30*/("""',
          match: /\B"""),_display_(/*25.22*/{provider.prefix}),format.raw/*25.39*/("""([\-+\w]*)$/,
          search: function (term, callback) """),format.raw/*26.45*/("""{"""),format.raw/*26.46*/("""
            """),format.raw/*27.13*/("""callback($.map("""),_display_(/*27.29*/{provider.id}),format.raw/*27.42*/(""", function (proposal) """),format.raw/*27.64*/("""{"""),format.raw/*27.65*/("""
              """),format.raw/*28.15*/("""return proposal.value.indexOf(term) === 0 ? proposal : null;
            """),format.raw/*29.13*/("""}"""),format.raw/*29.14*/("""));
          """),format.raw/*30.11*/("""}"""),format.raw/*30.12*/(""",
          template: function (option) """),format.raw/*31.39*/("""{"""),format.raw/*31.40*/("""
            """),format.raw/*32.13*/("""return """),_display_(/*32.21*/{Html(provider.template)}),format.raw/*32.46*/(""";
          """),format.raw/*33.11*/("""}"""),format.raw/*33.12*/(""",
          replace: function (option) """),format.raw/*34.38*/("""{"""),format.raw/*34.39*/("""
            """),format.raw/*35.13*/("""return '"""),_display_(/*35.22*/{provider.prefix}),format.raw/*35.39*/("""' + """),_display_(/*35.44*/{Html(provider.replace)}),format.raw/*35.68*/(""" """),format.raw/*35.69*/("""+ '"""),_display_(/*35.73*/{provider.suffix}),format.raw/*35.90*/("""';
          """),format.raw/*36.11*/("""}"""),format.raw/*36.12*/(""",
          index: 1
        """),format.raw/*38.9*/("""}"""),format.raw/*38.10*/(""",
      """)))} else {null} ),format.raw/*39.8*/("""
    """)))}),format.raw/*40.6*/("""
  """),format.raw/*41.3*/("""], """),format.raw/*41.6*/("""{"""),format.raw/*41.7*/("""
    """),format.raw/*42.5*/("""onKeydown: function (e, commands) """),format.raw/*42.39*/("""{"""),format.raw/*42.40*/("""
      """),format.raw/*43.7*/("""if (e.ctrlKey && e.keyCode === 74) """),format.raw/*43.42*/("""{"""),format.raw/*43.43*/(""" """),format.raw/*43.44*/("""// CTRL-J
        return commands.KEY_ENTER;
      """),format.raw/*45.7*/("""}"""),format.raw/*45.8*/("""
    """),format.raw/*46.5*/("""}"""),format.raw/*46.6*/("""
  """),format.raw/*47.3*/("""}"""),format.raw/*47.4*/(""");

  """),_display_(if(generateScript)/*49.22*/{_display_(Seq[Any](format.raw/*49.23*/("""
    """),format.raw/*50.5*/("""try """),format.raw/*50.9*/("""{"""),format.raw/*50.10*/("""
      """),format.raw/*51.7*/("""$([$('#"""),_display_(/*51.15*/textareaId),format.raw/*51.25*/("""')[0]]).dropzone("""),format.raw/*51.42*/("""{"""),format.raw/*51.43*/("""
        """),_display_(/*52.10*/dropzone(false, textareaId)),format.raw/*52.37*/("""
      """),format.raw/*53.7*/("""}"""),format.raw/*53.8*/(""");
      $([$('#"""),_display_(/*54.15*/textareaId),format.raw/*54.25*/("""').closest('div')[0], $('#"""),_display_(/*54.52*/textareaId),format.raw/*54.62*/("""').next('div')[0]]).dropzone("""),format.raw/*54.91*/("""{"""),format.raw/*54.92*/("""
        """),_display_(/*55.10*/dropzone(true, textareaId)),format.raw/*55.36*/("""
      """),format.raw/*56.7*/("""}"""),format.raw/*56.8*/(""");
    """),format.raw/*57.5*/("""}"""),format.raw/*57.6*/(""" """),format.raw/*57.7*/("""catch(e) """),format.raw/*57.16*/("""{"""),format.raw/*57.17*/("""
      """),format.raw/*58.7*/("""if (e.message !== "Dropzone already attached.") """),format.raw/*58.55*/("""{"""),format.raw/*58.56*/("""
        """),format.raw/*59.9*/("""throw e;
      """),format.raw/*60.7*/("""}"""),format.raw/*60.8*/("""
    """),format.raw/*61.5*/("""}"""),format.raw/*61.6*/("""
  """)))} else {null} ),format.raw/*62.4*/("""
"""),format.raw/*63.1*/("""}"""),format.raw/*63.2*/(""");

  $('#"""),_display_(/*65.8*/textareaId),format.raw/*65.18*/("""').bind('paste', function(e)"""),format.raw/*65.46*/("""{"""),format.raw/*65.47*/("""
    """),format.raw/*66.5*/("""const items = e.originalEvent.clipboardData.items;
    for (var i = 0; i < items.length; i++) """),format.raw/*67.44*/("""{"""),format.raw/*67.45*/("""
      """),format.raw/*68.7*/("""const item = items[i];
      if (item.type.indexOf('image') != -1) """),format.raw/*69.45*/("""{"""),format.raw/*69.46*/("""
        """),format.raw/*70.9*/("""const file = item.getAsFile();
        const formData = new FormData();
        formData.append('file', file);

        $.ajax("""),format.raw/*74.16*/("""{"""),format.raw/*74.17*/("""
          """),format.raw/*75.11*/("""url: '"""),_display_(/*75.18*/context/*75.25*/.path),format.raw/*75.30*/("""/upload/file/"""),_display_(/*75.44*/repository/*75.54*/.owner),format.raw/*75.60*/("""/"""),_display_(/*75.62*/repository/*75.72*/.name),format.raw/*75.77*/("""',
          type: 'POST',
          contentType: false,
          processData: false,
          data: formData,
          success: function(id) """),format.raw/*80.33*/("""{"""),format.raw/*80.34*/("""
            """),format.raw/*81.13*/("""const attachFile = `\n![$"""),format.raw/*81.38*/("""{"""),format.raw/*81.39*/("""file.name.split('.')[0]"""),format.raw/*81.62*/("""}"""),format.raw/*81.63*/("""]("""),_display_(/*81.66*/context/*81.73*/.baseUrl),format.raw/*81.81*/("""/"""),_display_(/*81.83*/repository/*81.93*/.owner),format.raw/*81.99*/("""/"""),_display_(/*81.101*/repository/*81.111*/.name),format.raw/*81.116*/("""/_attached/$"""),format.raw/*81.128*/("""{"""),format.raw/*81.129*/("""id"""),format.raw/*81.131*/("""}"""),format.raw/*81.132*/(""")`;
            $('#"""),_display_(/*82.18*/textareaId),format.raw/*82.28*/("""').val($('#"""),_display_(/*82.40*/textareaId),format.raw/*82.50*/("""').val() + attachFile);
          """),format.raw/*83.11*/("""}"""),format.raw/*83.12*/("""
        """),format.raw/*84.9*/("""}"""),format.raw/*84.10*/(""");
      """),format.raw/*85.7*/("""}"""),format.raw/*85.8*/("""
    """),format.raw/*86.5*/("""}"""),format.raw/*86.6*/("""
  """),format.raw/*87.3*/("""}"""),format.raw/*87.4*/(""");
</script>
""")))}),format.raw/*89.2*/("""
"""),format.raw/*102.2*/("""
"""))
      }
    }
  }

  def render(repository:gitbucket.core.service.RepositoryService.RepositoryInfo,completionContext:String,generateScript:Boolean,textarea:Html,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(repository,completionContext,generateScript)(textarea)(context)

  def f:((gitbucket.core.service.RepositoryService.RepositoryInfo,String,Boolean) => (Html) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (repository,completionContext,generateScript) => (textarea) => (context) => apply(repository,completionContext,generateScript)(textarea)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/helper/attached.scala.html
                  HASH: 02655a6fbd050b6dd4702c0b0634950bda6c005a
                  MATRIX: 688->1|960->202|1003->239|1051->3065|1068->3073|1197->3125|1227->3128|1261->3135|1277->3142|1303->3147|1344->3161|1363->3171|1390->3177|1419->3179|1438->3189|1464->3194|1510->3213|1582->3264|1623->3278|1677->3311|1720->3327|1750->3336|2059->3617|2088->3618|2120->3623|2264->3740|2280->3747|2309->3755|2338->3757|2357->3767|2384->3773|2413->3775|2432->3785|2458->3790|2519->3824|2550->3834|2589->3846|2620->3856|2747->3955|2776->3956|2816->274|2875->308|2903->316|2932->319|3068->430|3160->514|3213->529|3241->530|3290->551|3319->552|3349->556|3367->565|3432->621|3484->635|3565->689|3604->690|3638->697|3670->702|3687->710|3711->713|3740->714|3770->717|3924->850|3959->859|4023->902|4072->908|4106->912|4136->915|4167->920|4198->930|4247->953|4265->962|4330->1018|4382->1032|4465->1088|4504->1089|4540->1098|4569->1099|4608->1110|4641->1116|4675->1129|4726->1153|4764->1170|4850->1228|4879->1229|4920->1242|4963->1258|4997->1271|5047->1293|5076->1294|5119->1309|5220->1382|5249->1383|5291->1397|5320->1398|5388->1438|5417->1439|5458->1452|5493->1460|5539->1485|5579->1497|5608->1498|5675->1537|5704->1538|5745->1551|5781->1560|5819->1577|5851->1582|5896->1606|5925->1607|5956->1611|5994->1628|6035->1641|6064->1642|6120->1671|6149->1672|6201->1681|6237->1687|6267->1690|6297->1693|6325->1694|6357->1699|6419->1733|6448->1734|6482->1741|6545->1776|6574->1777|6603->1778|6681->1829|6709->1830|6741->1835|6769->1836|6799->1839|6827->1840|6879->1865|6918->1866|6950->1871|6981->1875|7010->1876|7044->1883|7079->1891|7110->1901|7155->1918|7184->1919|7221->1929|7269->1956|7303->1963|7331->1964|7375->1981|7406->1991|7460->2018|7491->2028|7548->2057|7577->2058|7614->2068|7661->2094|7695->2101|7723->2102|7757->2109|7785->2110|7813->2111|7850->2120|7879->2121|7913->2128|7989->2176|8018->2177|8054->2186|8096->2201|8124->2202|8156->2207|8184->2208|8231->2212|8259->2213|8287->2214|8324->2225|8355->2235|8411->2263|8440->2264|8472->2269|8594->2363|8623->2364|8657->2371|8752->2438|8781->2439|8817->2448|8972->2575|9001->2576|9040->2587|9074->2594|9090->2601|9116->2606|9157->2620|9176->2630|9203->2636|9232->2638|9251->2648|9277->2653|9450->2798|9479->2799|9520->2812|9573->2837|9602->2838|9653->2861|9682->2862|9712->2865|9728->2872|9757->2880|9786->2882|9805->2892|9832->2898|9862->2900|9882->2910|9909->2915|9950->2927|9980->2928|10011->2930|10041->2931|10089->2952|10120->2962|10159->2974|10190->2984|10252->3018|10281->3019|10317->3028|10346->3029|10382->3038|10410->3039|10442->3044|10470->3045|10500->3048|10528->3049|10572->3063|10601->3958
                  LINES: 14->1|18->3|19->4|21->90|21->90|23->90|24->91|24->91|24->91|24->91|24->91|24->91|24->91|24->91|24->91|24->91|25->92|25->92|26->93|26->93|27->94|27->94|29->96|29->96|30->97|31->98|31->98|31->98|31->98|31->98|31->98|31->98|31->98|31->98|32->99|32->99|32->99|32->99|34->101|34->101|36->5|37->6|37->6|38->7|40->9|40->9|40->9|41->10|42->11|42->11|43->12|43->12|43->12|43->12|44->13|44->13|45->14|45->14|45->14|45->14|45->14|45->14|47->16|48->17|48->17|49->18|50->19|51->20|51->20|51->20|52->21|52->21|52->21|52->21|53->22|53->22|54->23|54->23|55->24|55->24|55->24|56->25|56->25|57->26|57->26|58->27|58->27|58->27|58->27|58->27|59->28|60->29|60->29|61->30|61->30|62->31|62->31|63->32|63->32|63->32|64->33|64->33|65->34|65->34|66->35|66->35|66->35|66->35|66->35|66->35|66->35|66->35|67->36|67->36|69->38|69->38|70->39|71->40|72->41|72->41|72->41|73->42|73->42|73->42|74->43|74->43|74->43|74->43|76->45|76->45|77->46|77->46|78->47|78->47|80->49|80->49|81->50|81->50|81->50|82->51|82->51|82->51|82->51|82->51|83->52|83->52|84->53|84->53|85->54|85->54|85->54|85->54|85->54|85->54|86->55|86->55|87->56|87->56|88->57|88->57|88->57|88->57|88->57|89->58|89->58|89->58|90->59|91->60|91->60|92->61|92->61|93->62|94->63|94->63|96->65|96->65|96->65|96->65|97->66|98->67|98->67|99->68|100->69|100->69|101->70|105->74|105->74|106->75|106->75|106->75|106->75|106->75|106->75|106->75|106->75|106->75|106->75|111->80|111->80|112->81|112->81|112->81|112->81|112->81|112->81|112->81|112->81|112->81|112->81|112->81|112->81|112->81|112->81|112->81|112->81|112->81|112->81|113->82|113->82|113->82|113->82|114->83|114->83|115->84|115->84|116->85|116->85|117->86|117->86|118->87|118->87|120->89|121->102
                  -- GENERATED --
              */
          