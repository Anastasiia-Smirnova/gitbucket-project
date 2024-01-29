
package gitbucket.core.settings.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object issuesfieldform extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Option[gitbucket.core.model.CustomField],gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(field: Option[gitbucket.core.model.CustomField],
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*4.2*/defining(field.map(_.fieldId).getOrElse("new"))/*4.49*/{ fieldId =>_display_(Seq[Any](format.raw/*4.61*/("""
  """),format.raw/*5.3*/("""<div id="edit-field-area-"""),_display_(/*5.29*/fieldId),format.raw/*5.36*/("""">
    <form class="form-inline" autocomplete="off">
      <input type="text" id="fieldName-"""),_display_(/*7.41*/fieldId),format.raw/*7.48*/("""" style="width: 300px; float: left; margin-right: 4px;" class="form-control input-sm" value=""""),_display_(/*7.142*/field/*7.147*/.map(_.fieldName)),format.raw/*7.164*/("""""""),_display_(if(fieldId == "new")/*7.186*/{_display_(Seq[Any](format.raw/*7.187*/(""" """),format.raw/*7.188*/("""placeholder="New field name"""")))} else {null} ),format.raw/*7.217*/("""/>
      <select id="fieldType-"""),_display_(/*8.30*/fieldId),format.raw/*8.37*/("""" class="form-control input-sm">
        <option value="long" """),_display_(if(field.map(_.fieldType == "long").getOrElse(false))/*9.84*/{_display_(Seq[Any](format.raw/*9.85*/("""selected""")))} else {null} ),format.raw/*9.94*/(""">Long</option>
        <option value="double" """),_display_(if(field.map(_.fieldType == "double").getOrElse(false))/*10.88*/{_display_(Seq[Any](format.raw/*10.89*/("""selected""")))} else {null} ),format.raw/*10.98*/(""">Double</option>
        <option value="string" """),_display_(if(field.map(_.fieldType == "string").getOrElse(false))/*11.88*/{_display_(Seq[Any](format.raw/*11.89*/("""selected""")))} else {null} ),format.raw/*11.98*/(""">String</option>
        <option value="date" """),_display_(if(field.map(_.fieldType == "date").getOrElse(false))/*12.84*/{_display_(Seq[Any](format.raw/*12.85*/("""selected""")))} else {null} ),format.raw/*12.94*/(""">Date</option>
        <option value="enum" """),_display_(if(field.map(_.fieldType == "enum").getOrElse(false))/*13.84*/{_display_(Seq[Any](format.raw/*13.85*/("""selected""")))} else {null} ),format.raw/*13.94*/(""">Enum</option>
      </select>
      <input type="text" id="constraints-"""),_display_(/*15.43*/fieldId),format.raw/*15.50*/("""" style="width: 300px; """),_display_(if(!field.exists(_.fieldType == "enum"))/*15.114*/{_display_(Seq[Any](format.raw/*15.115*/("""display: none;""")))} else {null} ),format.raw/*15.130*/("""" class="form-control input-sm" value=""""),_display_(/*15.170*/field/*15.175*/.map(_.constraints)),format.raw/*15.194*/("""" placeholder="Comma-separated enum values">
      <label for="enableForIssues-"""),_display_(/*16.36*/fieldId),format.raw/*16.43*/("""" class="normal" style="margin-left: 4px;">
        <input type="checkbox" id="enableForIssues-"""),_display_(/*17.53*/fieldId),format.raw/*17.60*/("""" """),_display_(if(field.map(_.enableForIssues).getOrElse(false))/*17.112*/{_display_(Seq[Any](format.raw/*17.113*/("""checked""")))} else {null} ),format.raw/*17.121*/("""> Issues
      </label>
      <label for="enableForPullRequests-"""),_display_(/*19.42*/fieldId),format.raw/*19.49*/("""" class="normal" style="margin-left: 4px;">
        <input type="checkbox" id="enableForPullRequests-"""),_display_(/*20.59*/fieldId),format.raw/*20.66*/("""" """),_display_(if(field.map(_.enableForPullRequests).getOrElse(false))/*20.124*/{_display_(Seq[Any](format.raw/*20.125*/("""checked""")))} else {null} ),format.raw/*20.133*/("""> Pull requests
      </label>
      <span class="pull-right">
        <span id="field-error-"""),_display_(/*23.32*/fieldId),format.raw/*23.39*/("""" class="error"></span>
        <input type="button" id="cancel-"""),_display_(/*24.42*/fieldId),format.raw/*24.49*/("""" class="btn btn-sm btn-default field-edit-cancel" value="Cancel">
        <input type="button" id="submit-"""),_display_(/*25.42*/fieldId),format.raw/*25.49*/("""" class="btn btn-sm btn-success" style="margin-bottom: 0px;" value=""""),_display_(/*25.118*/(if(fieldId == "new") "Create field"  else "Save changes")),format.raw/*25.176*/(""""/>
      </span>
    </form>
  </div>
  <script>
  $(function()"""),format.raw/*30.15*/("""{"""),format.raw/*30.16*/("""
    """),format.raw/*31.5*/("""$('#submit-"""),_display_(/*31.17*/fieldId),format.raw/*31.24*/("""').click(function(e)"""),format.raw/*31.44*/("""{"""),format.raw/*31.45*/("""
      """),format.raw/*32.7*/("""$.post('"""),_display_(/*32.16*/helpers/*32.23*/.url(repository)),format.raw/*32.39*/("""/settings/issues/fields/"""),_display_(/*32.64*/{if(fieldId == "new") "new" else s"$fieldId/edit"}),format.raw/*32.114*/("""', """),format.raw/*32.117*/("""{"""),format.raw/*32.118*/("""
        """),format.raw/*33.9*/("""'fieldName' : $('#fieldName-"""),_display_(/*33.38*/fieldId),format.raw/*33.45*/("""').val(),
        'fieldType': $('#fieldType-"""),_display_(/*34.37*/fieldId),format.raw/*34.44*/(""" """),format.raw/*34.45*/("""option:selected').val(),
        'constraints': $('#constraints-"""),_display_(/*35.41*/fieldId),format.raw/*35.48*/("""').val(),
        'enableForIssues': $('#enableForIssues-"""),_display_(/*36.49*/fieldId),format.raw/*36.56*/("""').prop('checked'),
        'enableForPullRequests': $('#enableForPullRequests-"""),_display_(/*37.61*/fieldId),format.raw/*37.68*/("""').prop('checked')
      """),format.raw/*38.7*/("""}"""),format.raw/*38.8*/(""", function(data, status)"""),format.raw/*38.32*/("""{"""),format.raw/*38.33*/("""
        """),format.raw/*39.9*/("""$('div#edit-field-area-"""),_display_(/*39.33*/fieldId),format.raw/*39.40*/("""').remove();
        """),_display_(if(fieldId == "new")/*40.30*/{_display_(Seq[Any](format.raw/*40.31*/("""
          """),format.raw/*41.11*/("""$('#new-field-table').hide();
          // Insert row into the top of table
          $('#field-row-header').after(data);
        """)))}else/*44.16*/{_display_(Seq[Any](format.raw/*44.17*/("""
          """),format.raw/*45.11*/("""// Replace table row
          $('#field-row-"""),_display_(/*46.26*/fieldId),format.raw/*46.33*/("""').after(data).remove();
        """)))}),format.raw/*47.10*/("""
      """),format.raw/*48.7*/("""}"""),format.raw/*48.8*/(""").fail(function(xhr, status, error)"""),format.raw/*48.43*/("""{"""),format.raw/*48.44*/("""
        """),format.raw/*49.9*/("""const errors = JSON.parse(xhr.responseText);
        if(errors.fieldName)"""),format.raw/*50.29*/("""{"""),format.raw/*50.30*/("""
          """),format.raw/*51.11*/("""$('span#field-error-"""),_display_(/*51.32*/fieldId),format.raw/*51.39*/("""').text(errors.fieldName);
        """),format.raw/*52.9*/("""}"""),format.raw/*52.10*/(""" """),format.raw/*52.11*/("""else """),format.raw/*52.16*/("""{"""),format.raw/*52.17*/("""
          """),format.raw/*53.11*/("""$('span#field-error-"""),_display_(/*53.32*/fieldId),format.raw/*53.39*/("""').text('error');
        """),format.raw/*54.9*/("""}"""),format.raw/*54.10*/("""
      """),format.raw/*55.7*/("""}"""),format.raw/*55.8*/(""");
      return false;
    """),format.raw/*57.5*/("""}"""),format.raw/*57.6*/(""");

    $('#cancel-"""),_display_(/*59.17*/fieldId),format.raw/*59.24*/("""').click(function(e)"""),format.raw/*59.44*/("""{"""),format.raw/*59.45*/("""
      """),format.raw/*60.7*/("""$('div#edit-field-area-"""),_display_(/*60.31*/fieldId),format.raw/*60.38*/("""').remove();
      """),_display_(if(fieldId == "new")/*61.28*/{_display_(Seq[Any](format.raw/*61.29*/("""
        """),format.raw/*62.9*/("""$('#new-field-table').hide();
      """)))}else/*63.14*/{_display_(Seq[Any](format.raw/*63.15*/("""
        """),format.raw/*64.9*/("""$('#field-"""),_display_(/*64.20*/fieldId),format.raw/*64.27*/("""').show();
      """)))}),format.raw/*65.8*/("""
    """),format.raw/*66.5*/("""}"""),format.raw/*66.6*/(""");

    $('#fieldType-"""),_display_(/*68.20*/fieldId),format.raw/*68.27*/("""').change(function()"""),format.raw/*68.47*/("""{"""),format.raw/*68.48*/("""
      """),format.raw/*69.7*/("""if($(this).val() == 'enum') """),format.raw/*69.35*/("""{"""),format.raw/*69.36*/("""
        """),format.raw/*70.9*/("""$('#constraints-"""),_display_(/*70.26*/fieldId),format.raw/*70.33*/("""').show();
      """),format.raw/*71.7*/("""}"""),format.raw/*71.8*/(""" """),format.raw/*71.9*/("""else """),format.raw/*71.14*/("""{"""),format.raw/*71.15*/("""
        """),format.raw/*72.9*/("""$('#constraints-"""),_display_(/*72.26*/fieldId),format.raw/*72.33*/("""').hide();
      """),format.raw/*73.7*/("""}"""),format.raw/*73.8*/("""
    """),format.raw/*74.5*/("""}"""),format.raw/*74.6*/(""");
  """),format.raw/*75.3*/("""}"""),format.raw/*75.4*/(""");
  </script>
""")))}),format.raw/*77.2*/("""
"""))
      }
    }
  }

  def render(field:Option[gitbucket.core.model.CustomField],repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(field,repository)(context)

  def f:((Option[gitbucket.core.model.CustomField],gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (field,repository) => (context) => apply(field,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/settings/issuesfieldform.scala.html
                  HASH: 80ebcc96e72d97193cb5b9afb98e6b7deca2ca56
                  MATRIX: 718->1|964->176|1027->212|1082->259|1131->271|1160->274|1212->300|1239->307|1358->400|1385->407|1506->501|1520->506|1558->523|1607->545|1646->546|1675->547|1748->576|1806->608|1833->615|1975->731|2013->732|2065->741|2194->843|2233->844|2286->853|2417->957|2456->958|2509->967|2636->1067|2675->1068|2728->1077|2853->1175|2892->1176|2945->1185|3045->1258|3073->1265|3165->1329|3205->1330|3265->1345|3333->1385|3348->1390|3389->1409|3496->1489|3524->1496|3647->1592|3675->1599|3755->1651|3795->1652|3848->1660|3940->1725|3968->1732|4097->1834|4125->1841|4211->1899|4251->1900|4304->1908|4425->2002|4453->2009|4545->2074|4573->2081|4708->2189|4736->2196|4833->2265|4913->2323|5005->2387|5034->2388|5066->2393|5105->2405|5133->2412|5181->2432|5210->2433|5244->2440|5280->2449|5296->2456|5333->2472|5385->2497|5457->2547|5489->2550|5519->2551|5555->2560|5611->2589|5639->2596|5712->2642|5740->2649|5769->2650|5861->2715|5889->2722|5974->2780|6002->2787|6109->2867|6137->2874|6189->2899|6217->2900|6269->2924|6298->2925|6334->2934|6385->2958|6413->2965|6482->3007|6521->3008|6560->3019|6714->3156|6753->3157|6792->3168|6865->3214|6893->3221|6958->3255|6992->3262|7020->3263|7083->3298|7112->3299|7148->3308|7249->3381|7278->3382|7317->3393|7365->3414|7393->3421|7455->3456|7484->3457|7513->3458|7546->3463|7575->3464|7614->3475|7662->3496|7690->3503|7743->3529|7772->3530|7806->3537|7834->3538|7888->3565|7916->3566|7963->3586|7991->3593|8039->3613|8068->3614|8102->3621|8153->3645|8181->3652|8248->3692|8287->3693|8323->3702|8383->3745|8422->3746|8458->3755|8496->3766|8524->3773|8572->3791|8604->3796|8632->3797|8682->3820|8710->3827|8758->3847|8787->3848|8821->3855|8877->3883|8906->3884|8942->3893|8986->3910|9014->3917|9058->3934|9086->3935|9114->3936|9147->3941|9176->3942|9212->3951|9256->3968|9284->3975|9328->3992|9356->3993|9388->3998|9416->3999|9448->4004|9476->4005|9522->4021
                  LINES: 14->1|18->3|21->4|21->4|21->4|22->5|22->5|22->5|24->7|24->7|24->7|24->7|24->7|24->7|24->7|24->7|24->7|25->8|25->8|26->9|26->9|26->9|27->10|27->10|27->10|28->11|28->11|28->11|29->12|29->12|29->12|30->13|30->13|30->13|32->15|32->15|32->15|32->15|32->15|32->15|32->15|32->15|33->16|33->16|34->17|34->17|34->17|34->17|34->17|36->19|36->19|37->20|37->20|37->20|37->20|37->20|40->23|40->23|41->24|41->24|42->25|42->25|42->25|42->25|47->30|47->30|48->31|48->31|48->31|48->31|48->31|49->32|49->32|49->32|49->32|49->32|49->32|49->32|49->32|50->33|50->33|50->33|51->34|51->34|51->34|52->35|52->35|53->36|53->36|54->37|54->37|55->38|55->38|55->38|55->38|56->39|56->39|56->39|57->40|57->40|58->41|61->44|61->44|62->45|63->46|63->46|64->47|65->48|65->48|65->48|65->48|66->49|67->50|67->50|68->51|68->51|68->51|69->52|69->52|69->52|69->52|69->52|70->53|70->53|70->53|71->54|71->54|72->55|72->55|74->57|74->57|76->59|76->59|76->59|76->59|77->60|77->60|77->60|78->61|78->61|79->62|80->63|80->63|81->64|81->64|81->64|82->65|83->66|83->66|85->68|85->68|85->68|85->68|86->69|86->69|86->69|87->70|87->70|87->70|88->71|88->71|88->71|88->71|88->71|89->72|89->72|89->72|90->73|90->73|91->74|91->74|92->75|92->75|94->77
                  -- GENERATED --
              */
          