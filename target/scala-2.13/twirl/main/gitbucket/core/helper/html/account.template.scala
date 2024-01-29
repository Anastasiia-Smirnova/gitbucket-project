
package gitbucket.core.helper.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object account extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[String,Int,Boolean,Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(id: String, width: Int, user: Boolean, group: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<span style="margin-right: 0px;">
  <input type="text" name=""""),_display_(/*3.29*/id),format.raw/*3.31*/("""" id=""""),_display_(/*3.38*/id),format.raw/*3.40*/("""" class="form-control" autocomplete="off" style="width: """),_display_(/*3.97*/{width}),format.raw/*3.104*/("""px; margin-bottom: 0px; display: inline; vertical-align: middle;" aria-label=""""),_display_(/*3.183*/id),format.raw/*3.185*/(""""/>
</span>
<script>
$(function()"""),format.raw/*6.13*/("""{"""),format.raw/*6.14*/("""
  """),format.raw/*7.3*/("""$('#"""),_display_(/*7.8*/id),format.raw/*7.10*/("""').typeahead("""),format.raw/*7.23*/("""{"""),format.raw/*7.24*/("""
"""),format.raw/*8.1*/("""//    highlighter: function(item) """),format.raw/*8.35*/("""{"""),format.raw/*8.36*/("""
"""),format.raw/*9.1*/("""//      var x = item.split(':');
//      return $('<div><strong>' + x[0] + '</strong>' + (x[1] == 'true' ? ' (group)' : '') + '</div>');
//    """),format.raw/*11.7*/("""}"""),format.raw/*11.8*/(""",
//    updater: function (item) """),format.raw/*12.32*/("""{"""),format.raw/*12.33*/("""
"""),format.raw/*13.1*/("""//      return item.split(':')[0];
//    """),format.raw/*14.7*/("""}"""),format.raw/*14.8*/(""",
    source: function (query, process) """),format.raw/*15.39*/("""{"""),format.raw/*15.40*/("""
      """),format.raw/*16.7*/("""return $.get('"""),_display_(/*16.22*/context/*16.29*/.path),format.raw/*16.34*/("""/_user/proposals', """),format.raw/*16.53*/("""{"""),format.raw/*16.54*/(""" """),format.raw/*16.55*/("""query: query, user: """),_display_(/*16.76*/user),format.raw/*16.80*/(""", group: """),_display_(/*16.90*/group),format.raw/*16.95*/(""" """),format.raw/*16.96*/("""}"""),format.raw/*16.97*/(""",
        function (data) """),format.raw/*17.25*/("""{"""),format.raw/*17.26*/("""
          """),format.raw/*18.11*/("""return process(data.options);
        """),format.raw/*19.9*/("""}"""),format.raw/*19.10*/(""");
    """),format.raw/*20.5*/("""}"""),format.raw/*20.6*/(""",
    displayText: function(item) """),format.raw/*21.33*/("""{"""),format.raw/*21.34*/("""
      """),format.raw/*22.7*/("""return item.label;
    """),format.raw/*23.5*/("""}"""),format.raw/*23.6*/(""",
    afterSelect: function(item) """),format.raw/*24.33*/("""{"""),format.raw/*24.34*/("""
      """),format.raw/*25.7*/("""$('#"""),_display_(/*25.12*/id),format.raw/*25.14*/("""').val(item.value);
    """),format.raw/*26.5*/("""}"""),format.raw/*26.6*/("""
  """),format.raw/*27.3*/("""}"""),format.raw/*27.4*/(""");
"""),format.raw/*28.1*/("""}"""),format.raw/*28.2*/(""");
</script>
"""))
      }
    }
  }

  def render(id:String,width:Int,user:Boolean,group:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(id,width,user,group)(context)

  def f:((String,Int,Boolean,Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (id,width,user,group) => (context) => apply(id,width,user,group)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/helper/account.scala.html
                  HASH: efbd3763ce8370612d0121040125388dd39dd149
                  MATRIX: 638->1|840->110|928->172|950->174|983->181|1005->183|1088->240|1116->247|1222->326|1245->328|1305->361|1333->362|1362->365|1392->370|1414->372|1454->385|1482->386|1509->387|1570->421|1598->422|1625->423|1795->566|1823->567|1884->600|1913->601|1941->602|2009->643|2037->644|2105->684|2134->685|2168->692|2210->707|2226->714|2252->719|2299->738|2328->739|2357->740|2405->761|2430->765|2467->775|2493->780|2522->781|2551->782|2605->808|2634->809|2673->820|2738->858|2767->859|2801->866|2829->867|2891->901|2920->902|2954->909|3004->932|3032->933|3094->967|3123->968|3157->975|3189->980|3212->982|3263->1006|3291->1007|3321->1010|3349->1011|3379->1014|3407->1015
                  LINES: 14->1|19->2|20->3|20->3|20->3|20->3|20->3|20->3|20->3|20->3|23->6|23->6|24->7|24->7|24->7|24->7|24->7|25->8|25->8|25->8|26->9|28->11|28->11|29->12|29->12|30->13|31->14|31->14|32->15|32->15|33->16|33->16|33->16|33->16|33->16|33->16|33->16|33->16|33->16|33->16|33->16|33->16|33->16|34->17|34->17|35->18|36->19|36->19|37->20|37->20|38->21|38->21|39->22|40->23|40->23|41->24|41->24|42->25|42->25|42->25|43->26|43->26|44->27|44->27|45->28|45->28
                  -- GENERATED --
              */
          