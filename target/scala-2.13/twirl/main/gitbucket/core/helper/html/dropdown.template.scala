
package gitbucket.core.helper.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object dropdown extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template7[String,String,String,String,Boolean,(String, String),Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(value : String  = "",
  prefix: String  = "",
  style : String  = "",
  maxValueWidth : String  = "",
  right : Boolean = false,
  filter: (String, String)  = ("",""))(body: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*7.2*/defining(if(filter._1.isEmpty) "" else filter._1 + "-" + scala.util.Random.alphanumeric.take(4).mkString)/*7.107*/{ filterId =>_display_(Seq[Any](format.raw/*7.120*/("""
  """),format.raw/*8.3*/("""<div class="btn-group" """),_display_(if(style.nonEmpty)/*8.45*/{_display_(Seq[Any](format.raw/*8.46*/("""style=""""),_display_(/*8.54*/style),format.raw/*8.59*/(""""""")))} else {null} ),format.raw/*8.61*/(""">
    <button class="dropdown-toggle btn btn-default btn-sm" data-toggle="dropdown">
      """),_display_(if(value.isEmpty)/*10.25*/{_display_(Seq[Any](format.raw/*10.26*/("""
        """),format.raw/*11.9*/("""<i class="octicon octicon-gear"></i>
      """)))}else/*12.14*/{_display_(Seq[Any](format.raw/*12.15*/("""
        """),_display_(if(prefix.nonEmpty)/*13.29*/{_display_(Seq[Any](format.raw/*13.30*/("""
          """),format.raw/*14.11*/("""<span class="muted">"""),_display_(/*14.32*/prefix),format.raw/*14.38*/(""":</span>
        """)))} else {null} ),format.raw/*15.10*/("""
        """),format.raw/*16.9*/("""<span class="strong"
              """),_display_(if(maxValueWidth.nonEmpty)/*17.42*/{_display_(Seq[Any](format.raw/*17.43*/("""style="display:inline-block; vertical-align:bottom; overflow-x:hidden; max-width:"""),_display_(/*17.125*/maxValueWidth),format.raw/*17.138*/("""; text-overflow:ellipsis"""")))} else {null} ),format.raw/*17.164*/(""">
          """),_display_(/*18.12*/value),format.raw/*18.17*/("""
        """),format.raw/*19.9*/("""</span>
      """)))}),format.raw/*20.8*/("""
      """),format.raw/*21.7*/("""<span class="caret"></span>
    </button>
    <ul class="dropdown-menu"""),_display_(if(right)/*23.39*/{_display_(Seq[Any](format.raw/*23.40*/(""" """),format.raw/*23.41*/("""pull-right""")))} else {null} ),format.raw/*23.52*/("""">
      """),_display_(if(filterId.nonEmpty)/*24.29*/ {_display_(Seq[Any](format.raw/*24.31*/("""
        """),format.raw/*25.9*/("""<li><input id=""""),_display_(/*25.25*/filterId),format.raw/*25.33*/("""-input" type="text" class="form-control input-sm dropdown-filter-input" placeholder=""""),_display_(/*25.119*/filter/*25.125*/._2),format.raw/*25.128*/(""""/></li>
      """)))} else {null} ),format.raw/*26.8*/("""
      """),_display_(/*27.8*/body),format.raw/*27.12*/("""
    """),format.raw/*28.5*/("""</ul>
  </div>
  """),_display_(if(filterId.nonEmpty)/*30.25*/ {_display_(Seq[Any](format.raw/*30.27*/("""
    """),format.raw/*31.5*/("""<script>
    $(window).on('load', function()"""),format.raw/*32.36*/("""{"""),format.raw/*32.37*/("""
      """),format.raw/*33.7*/("""$('#"""),_display_(/*33.12*/{filterId}),format.raw/*33.22*/("""-input').parent().click(function(e) """),format.raw/*33.58*/("""{"""),format.raw/*33.59*/("""
        """),format.raw/*34.9*/("""e.stopPropagation();
      """),format.raw/*35.7*/("""}"""),format.raw/*35.8*/(""");
      $('#"""),_display_(/*36.12*/{filterId}),format.raw/*36.22*/("""-input').keyup(function() """),format.raw/*36.48*/("""{"""),format.raw/*36.49*/("""
        """),format.raw/*37.9*/("""var inputVal = $('#"""),_display_(/*37.29*/{filterId}),format.raw/*37.39*/("""-input').val();
        $.each($('#"""),_display_(/*38.21*/{filterId}),format.raw/*38.31*/("""-input').parent().parent().find('a'), function(index, elem) """),format.raw/*38.91*/("""{"""),format.raw/*38.92*/("""
          """),format.raw/*39.11*/("""if ( !inputVal || !elem.text.trim() || elem.text.trim().toLowerCase().indexOf(inputVal.toLowerCase()) >=0 ) """),format.raw/*39.119*/("""{"""),format.raw/*39.120*/("""
            """),format.raw/*40.13*/("""$(elem).parent().show();
          """),format.raw/*41.11*/("""}"""),format.raw/*41.12*/(""" """),format.raw/*41.13*/("""else """),format.raw/*41.18*/("""{"""),format.raw/*41.19*/("""
            """),format.raw/*42.13*/("""$(elem).parent().hide();
          """),format.raw/*43.11*/("""}"""),format.raw/*43.12*/("""
        """),format.raw/*44.9*/("""}"""),format.raw/*44.10*/(""");
      """),format.raw/*45.7*/("""}"""),format.raw/*45.8*/(""");
    """),format.raw/*46.5*/("""}"""),format.raw/*46.6*/(""");
    </script>
  """)))} else {null} ),format.raw/*48.4*/("""
""")))}),format.raw/*49.2*/("""
"""))
      }
    }
  }

  def render(value:String,prefix:String,style:String,maxValueWidth:String,right:Boolean,filter:(String, String),body:Html): play.twirl.api.HtmlFormat.Appendable = apply(value,prefix,style,maxValueWidth,right,filter)(body)

  def f:((String,String,String,String,Boolean,(String, String)) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (value,prefix,style,maxValueWidth,right,filter) => (body) => apply(value,prefix,style,maxValueWidth,right,filter)(body)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/helper/dropdown.scala.html
                  HASH: b3541e977de1ed02ba3203463811dc7df899884a
                  MATRIX: 636->1|910->183|1024->288|1075->301|1104->304|1172->346|1210->347|1244->355|1269->360|1314->362|1450->471|1489->472|1525->481|1592->531|1631->532|1687->561|1726->562|1765->573|1813->594|1840->600|1902->618|1938->627|2027->689|2066->690|2176->772|2211->785|2282->811|2322->824|2348->829|2384->838|2429->853|2463->860|2570->940|2609->941|2638->942|2693->953|2751->984|2791->986|2827->995|2870->1011|2899->1019|3013->1105|3029->1111|3054->1114|3113->1130|3147->1138|3172->1142|3204->1147|3270->1186|3310->1188|3342->1193|3414->1237|3443->1238|3477->1245|3509->1250|3540->1260|3604->1296|3633->1297|3669->1306|3723->1333|3751->1334|3792->1348|3823->1358|3877->1384|3906->1385|3942->1394|3989->1414|4020->1424|4083->1460|4114->1470|4202->1530|4231->1531|4270->1542|4407->1650|4437->1651|4478->1664|4541->1699|4570->1700|4599->1701|4632->1706|4661->1707|4702->1720|4765->1755|4794->1756|4830->1765|4859->1766|4895->1775|4923->1776|4957->1783|4985->1784|5048->1804|5080->1806
                  LINES: 14->1|24->7|24->7|24->7|25->8|25->8|25->8|25->8|25->8|25->8|27->10|27->10|28->11|29->12|29->12|30->13|30->13|31->14|31->14|31->14|32->15|33->16|34->17|34->17|34->17|34->17|34->17|35->18|35->18|36->19|37->20|38->21|40->23|40->23|40->23|40->23|41->24|41->24|42->25|42->25|42->25|42->25|42->25|42->25|43->26|44->27|44->27|45->28|47->30|47->30|48->31|49->32|49->32|50->33|50->33|50->33|50->33|50->33|51->34|52->35|52->35|53->36|53->36|53->36|53->36|54->37|54->37|54->37|55->38|55->38|55->38|55->38|56->39|56->39|56->39|57->40|58->41|58->41|58->41|58->41|58->41|59->42|60->43|60->43|61->44|61->44|62->45|62->45|63->46|63->46|65->48|66->49
                  -- GENERATED --
              */
          