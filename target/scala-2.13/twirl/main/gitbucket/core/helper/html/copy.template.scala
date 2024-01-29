
package gitbucket.core.helper.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object copy extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[String,String,String,String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(targetTextId: String, copyButtonId: String, value: String, style: String = "")(html: Html = Html("")):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(if(html.body.nonEmpty)/*2.24*/{_display_(Seq[Any](format.raw/*2.25*/("""
  """),format.raw/*3.3*/("""<div class="input-group" style="margin-bottom: 0px;">
    """),_display_(/*4.6*/html),format.raw/*4.10*/("""
    """),format.raw/*5.5*/("""<span class="input-group-btn">
      <span id=""""),_display_(/*6.18*/copyButtonId),format.raw/*6.30*/("""" class="btn btn-sm btn-default" """),_display_(if(style.nonEmpty)/*6.82*/{_display_(Seq[Any](format.raw/*6.83*/("""style=""""),_display_(/*6.91*/style),format.raw/*6.96*/(""""""")))} else {null} ),format.raw/*6.98*/("""
        """),format.raw/*7.9*/("""data-clipboard-text=""""),_display_(/*7.31*/value),format.raw/*7.36*/("""" data-placement="bottom" title="copy to clipboard"><i class="octicon octicon-clippy"></i></span>
    </span>
  </div>
""")))}else/*10.8*/{_display_(Seq[Any](format.raw/*10.9*/("""
  """),format.raw/*11.3*/("""<span id=""""),_display_(/*11.14*/copyButtonId),format.raw/*11.26*/("""" class="btn btn-sm btn-default" """),_display_(if(style.nonEmpty)/*11.78*/{_display_(Seq[Any](format.raw/*11.79*/("""style=""""),_display_(/*11.87*/style),format.raw/*11.92*/(""""""")))} else {null} ),format.raw/*11.94*/("""
    """),format.raw/*12.5*/("""data-clipboard-text=""""),_display_(/*12.27*/value),format.raw/*12.32*/("""" data-placement="bottom" title="copy to clipboard"><i class="octicon octicon-clippy"></i></span>
""")))}),format.raw/*13.2*/("""
"""),format.raw/*14.1*/("""<script>
// copy to clipboard
(function() """),format.raw/*16.13*/("""{"""),format.raw/*16.14*/("""
  """),format.raw/*17.3*/("""// if document.execCommand('copy') is available, use it for copy.
  if (document.queryCommandSupported('copy')) """),format.raw/*18.47*/("""{"""),format.raw/*18.48*/("""
    """),format.raw/*19.5*/("""var title = $('#"""),_display_(/*19.22*/copyButtonId),format.raw/*19.34*/("""').attr('title');
    $('#"""),_display_(/*20.10*/copyButtonId),format.raw/*20.22*/("""').tooltip("""),format.raw/*20.33*/("""{"""),format.raw/*20.34*/("""
      """),format.raw/*21.113*/("""
      """),format.raw/*22.7*/("""container: 'body'
    """),format.raw/*23.5*/("""}"""),format.raw/*23.6*/(""");
    $('#"""),_display_(/*24.10*/copyButtonId),format.raw/*24.22*/("""').on('click', function() """),format.raw/*24.48*/("""{"""),format.raw/*24.49*/("""
      """),format.raw/*25.7*/("""var target = document.getElementById('"""),_display_(/*25.46*/targetTextId),format.raw/*25.58*/("""');
      if (!target) """),format.raw/*26.20*/("""{"""),format.raw/*26.21*/(""" """),format.raw/*26.74*/("""
        """),format.raw/*27.9*/("""$('#"""),_display_(/*27.14*/copyButtonId),format.raw/*27.26*/("""').attr('title', 'failed to copy').tooltip('fixTitle').tooltip('show');
        return;
      """),format.raw/*29.7*/("""}"""),format.raw/*29.8*/("""
      """),format.raw/*30.7*/("""if (typeof target.select === 'function') """),format.raw/*30.48*/("""{"""),format.raw/*30.49*/("""
        """),format.raw/*31.9*/("""target.select();
      """),format.raw/*32.7*/("""}"""),format.raw/*32.8*/(""" """),format.raw/*32.9*/("""else """),format.raw/*32.14*/("""{"""),format.raw/*32.15*/("""
        """),format.raw/*33.9*/("""var range = document.createRange();
        range.selectNodeContents(target);
        var selection = window.getSelection();
        selection.removeAllRanges();
        selection.addRange(range);
      """),format.raw/*38.7*/("""}"""),format.raw/*38.8*/("""
      """),format.raw/*39.7*/("""document.execCommand('copy');
      $('#"""),_display_(/*40.12*/copyButtonId),format.raw/*40.24*/("""').attr('title', 'copied!').tooltip('fixTitle').tooltip('show');
      $('#"""),_display_(/*41.12*/copyButtonId),format.raw/*41.24*/("""').attr('title', title).tooltip('fixTitle');
    """),format.raw/*42.5*/("""}"""),format.raw/*42.6*/(""");
  """),format.raw/*43.3*/("""}"""),format.raw/*43.4*/(""" """),format.raw/*43.5*/("""else """),format.raw/*43.10*/("""{"""),format.raw/*43.11*/("""
    """),format.raw/*44.5*/("""// if copy is not supported, remove the copy button
    $('#"""),_display_(/*45.10*/copyButtonId),format.raw/*45.22*/("""').remove();
  """),format.raw/*46.3*/("""}"""),format.raw/*46.4*/("""
"""),format.raw/*47.1*/("""}"""),format.raw/*47.2*/(""")();
</script>
"""))
      }
    }
  }

  def render(targetTextId:String,copyButtonId:String,value:String,style:String,html:Html): play.twirl.api.HtmlFormat.Appendable = apply(targetTextId,copyButtonId,value,style)(html)

  def f:((String,String,String,String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (targetTextId,copyButtonId,value,style) => (html) => apply(targetTextId,copyButtonId,value,style)(html)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/helper/copy.scala.html
                  HASH: c545f11ffa7ac2fb995f2b8aff9441c4bb5eb6c1
                  MATRIX: 607->1|826->127|864->128|893->131|977->190|1001->194|1032->199|1106->247|1138->259|1216->311|1254->312|1288->320|1313->325|1358->327|1393->336|1441->358|1466->363|1608->489|1646->490|1676->493|1714->504|1747->516|1826->568|1865->569|1900->577|1926->582|1972->584|2004->589|2053->611|2079->616|2208->715|2236->716|2306->758|2335->759|2365->762|2505->874|2534->875|2566->880|2610->897|2643->909|2697->936|2730->948|2769->959|2798->960|2834->1073|2868->1080|2917->1102|2945->1103|2984->1115|3017->1127|3071->1153|3100->1154|3134->1161|3200->1200|3233->1212|3284->1235|3313->1236|3342->1289|3378->1298|3410->1303|3443->1315|3564->1409|3592->1410|3626->1417|3695->1458|3724->1459|3760->1468|3810->1491|3838->1492|3866->1493|3899->1498|3928->1499|3964->1508|4194->1711|4222->1712|4256->1719|4324->1760|4357->1772|4460->1848|4493->1860|4569->1909|4597->1910|4629->1915|4657->1916|4685->1917|4718->1922|4747->1923|4779->1928|4867->1989|4900->2001|4942->2016|4970->2017|4998->2018|5026->2019
                  LINES: 14->1|19->2|19->2|20->3|21->4|21->4|22->5|23->6|23->6|23->6|23->6|23->6|23->6|23->6|24->7|24->7|24->7|27->10|27->10|28->11|28->11|28->11|28->11|28->11|28->11|28->11|28->11|29->12|29->12|29->12|30->13|31->14|33->16|33->16|34->17|35->18|35->18|36->19|36->19|36->19|37->20|37->20|37->20|37->20|38->21|39->22|40->23|40->23|41->24|41->24|41->24|41->24|42->25|42->25|42->25|43->26|43->26|43->26|44->27|44->27|44->27|46->29|46->29|47->30|47->30|47->30|48->31|49->32|49->32|49->32|49->32|49->32|50->33|55->38|55->38|56->39|57->40|57->40|58->41|58->41|59->42|59->42|60->43|60->43|60->43|60->43|60->43|61->44|62->45|62->45|63->46|63->46|64->47|64->47
                  -- GENERATED --
              */
          