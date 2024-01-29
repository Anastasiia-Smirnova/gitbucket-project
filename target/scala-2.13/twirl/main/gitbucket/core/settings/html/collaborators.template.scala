
package gitbucket.core.settings.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object collaborators extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[List[(gitbucket.core.model.Collaborator, Boolean)],Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(collaborators: List[(gitbucket.core.model.Collaborator, Boolean)],
  isGroupRepository: Boolean,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*4.2*/import gitbucket.core.view.helpers
/*5.2*/import gitbucket.core.model.Role


Seq[Any](_display_(/*6.2*/gitbucket/*6.11*/.core.html.main("Settings", Some(repository))/*6.56*/{_display_(Seq[Any](format.raw/*6.57*/("""
  """),_display_(/*7.4*/gitbucket/*7.13*/.core.html.menu("settings", repository)/*7.52*/{_display_(Seq[Any](format.raw/*7.53*/("""
    """),_display_(/*8.6*/gitbucket/*8.15*/.core.settings.html.menu("collaborators", repository)/*8.68*/{_display_(Seq[Any](format.raw/*8.69*/("""
      """),format.raw/*9.7*/("""<form id="form" method="post" action=""""),_display_(/*9.46*/helpers/*9.53*/.url(repository)),format.raw/*9.69*/("""/settings/collaborators" autocomplete="off">
        <div class="panel panel-default">
          <div class="panel-heading strong">Collaborators</div>
          <div class="panel-body">
            <ul id="collaborator-list" class="collaborator">
            </ul>
            """),_display_(/*15.14*/gitbucket/*15.23*/.core.helper.html.account("userName-collaborator", 200, true, false)),format.raw/*15.91*/("""
            """),format.raw/*16.13*/("""<input type="button" class="btn btn-default add" value="Add" id="addCollaborator"/>
            <div>
              <span class="error" id="error-collaborator"></span>
            </div>
          </div>
        </div>

        <div class="panel panel-default">
          <div class="panel-heading strong">Groups</div>
          <div class="panel-body">
            <ul id="group-list" class="collaborator">
            </ul>
            """),_display_(/*28.14*/gitbucket/*28.23*/.core.helper.html.account("userName-group", 200, false, true)),format.raw/*28.84*/("""
            """),format.raw/*29.13*/("""<input type="button" class="btn btn-default add" value="Add" id="addGroup"/>
            <div>
              <span class="error" id="error-group"></span>
            </div>
          </div>
        </div>

        <div class="align-right" style="margin-top: 20px;">
          <input type="hidden" id="collaborators" name="collaborators" />
          <input type="submit" class="btn btn-success" value="Apply changes"/>
        </div>
      </form>
    """)))}),format.raw/*41.6*/("""
  """)))}),format.raw/*42.4*/("""
""")))}),format.raw/*43.2*/("""
"""),format.raw/*44.1*/("""<script>
$(function()"""),format.raw/*45.13*/("""{"""),format.raw/*45.14*/("""
  """),format.raw/*46.3*/("""$('input[type=submit]').click(function()"""),format.raw/*46.43*/("""{"""),format.raw/*46.44*/("""
    """),format.raw/*47.5*/("""updateValues();
  """),format.raw/*48.3*/("""}"""),format.raw/*48.4*/(""");

  $('.add').click(function()"""),format.raw/*50.29*/("""{"""),format.raw/*50.30*/("""
    """),format.raw/*51.5*/("""var id = $(this).attr('id') == 'addCollaborator' ? 'collaborator' : 'group';

    $('#error-' + id).text('');
    var userName = $('#userName-' + id).val();

    // check empty
    if($.trim(userName) == '')"""),format.raw/*57.31*/("""{"""),format.raw/*57.32*/("""
      """),format.raw/*58.7*/("""return false;
    """),format.raw/*59.5*/("""}"""),format.raw/*59.6*/("""

    """),format.raw/*61.5*/("""// check owner
    var owner = '"""),_display_(/*62.19*/repository/*62.29*/.owner),format.raw/*62.35*/("""' == userName
    if(owner)"""),format.raw/*63.14*/("""{"""),format.raw/*63.15*/("""
      """),format.raw/*64.7*/("""$('#error-' + id).text('User is owner of this repository.');
      return false;
    """),format.raw/*66.5*/("""}"""),format.raw/*66.6*/("""
    """),format.raw/*67.5*/("""// check duplication
    var exists = $('#' + id + '-list li').filter(function()"""),format.raw/*68.60*/("""{"""),format.raw/*68.61*/("""
      """),format.raw/*69.7*/("""return $(this).data('name') == userName;
    """),format.raw/*70.5*/("""}"""),format.raw/*70.6*/(""").length > 0;
    if(exists)"""),format.raw/*71.15*/("""{"""),format.raw/*71.16*/("""
      """),format.raw/*72.7*/("""$('#error-' + id).text('User has been already added.');
      return false;
    """),format.raw/*74.5*/("""}"""),format.raw/*74.6*/("""

    """),format.raw/*76.5*/("""// check existence
    $.post('"""),_display_(/*77.14*/context/*77.21*/.path),format.raw/*77.26*/("""/_user/existence', """),format.raw/*77.45*/("""{"""),format.raw/*77.46*/(""" """),format.raw/*77.47*/("""'userName': userName """),format.raw/*77.68*/("""}"""),format.raw/*77.69*/(""",
      function(data, status)"""),format.raw/*78.29*/("""{"""),format.raw/*78.30*/("""
        """),format.raw/*79.9*/("""if(data != '')"""),format.raw/*79.23*/("""{"""),format.raw/*79.24*/("""
          """),format.raw/*80.11*/("""addListHTML(userName, '"""),_display_(/*80.35*/Role/*80.39*/.ADMIN.name),format.raw/*80.50*/("""', '#' + id + '-list');
          $('#userName-' + id).val('');
        """),format.raw/*82.9*/("""}"""),format.raw/*82.10*/(""" """),format.raw/*82.11*/("""else """),format.raw/*82.16*/("""{"""),format.raw/*82.17*/("""
          """),format.raw/*83.11*/("""$('#error-' + id).text('User does not exist.');
        """),format.raw/*84.9*/("""}"""),format.raw/*84.10*/("""
      """),format.raw/*85.7*/("""}"""),format.raw/*85.8*/(""");
  """),format.raw/*86.3*/("""}"""),format.raw/*86.4*/(""");

  $(document).on('click', '.remove', function()"""),format.raw/*88.48*/("""{"""),format.raw/*88.49*/("""
    """),format.raw/*89.5*/("""$(this).parent().remove();
  """),format.raw/*90.3*/("""}"""),format.raw/*90.4*/(""");

  // Don't submit form by ENTER key
  $('#userName-collaborator, #userName-group').keypress(function(e)"""),format.raw/*93.68*/("""{"""),format.raw/*93.69*/("""
    """),format.raw/*94.5*/("""return !(e.keyCode == 13);
  """),format.raw/*95.3*/("""}"""),format.raw/*95.4*/(""");

  """),_display_(/*97.4*/collaborators/*97.17*/.map/*97.21*/ { case (collaborator, isGroup) =>_display_(Seq[Any](format.raw/*97.55*/("""
    """),format.raw/*98.5*/("""addListHTML('"""),_display_(/*98.19*/collaborator/*98.31*/.collaboratorName),format.raw/*98.48*/("""', '"""),_display_(/*98.53*/collaborator/*98.65*/.role),format.raw/*98.70*/("""', """),_display_(if(isGroup)/*98.85*/{_display_(Seq[Any](format.raw/*98.86*/("""'#group-list'""")))}else/*98.104*/{_display_(Seq[Any](format.raw/*98.105*/("""'#collaborator-list'""")))}),format.raw/*98.126*/(""");
  """)))}),format.raw/*99.4*/("""

  """),format.raw/*101.3*/("""function addListHTML(userName, role, id)"""),format.raw/*101.43*/("""{"""),format.raw/*101.44*/("""
    """),format.raw/*102.5*/("""var adminButton = $('<label class="btn btn-default btn-mini"><input type="radio" value=""""),_display_(/*102.94*/Role/*102.98*/.ADMIN.name),format.raw/*102.109*/("""" name="' + userName + '">Admin</label>');
    if(role == '"""),_display_(/*103.18*/Role/*103.22*/.ADMIN.name),format.raw/*103.33*/("""')"""),format.raw/*103.35*/("""{"""),format.raw/*103.36*/("""
      """),format.raw/*104.7*/("""adminButton.addClass('active');
    """),format.raw/*105.5*/("""}"""),format.raw/*105.6*/("""
    """),format.raw/*106.5*/("""var writeButton = $('<label class="btn btn-default btn-mini"><input type="radio" value=""""),_display_(/*106.94*/Role/*106.98*/.DEVELOPER.name),format.raw/*106.113*/("""" name="' + userName + '">Developer</label>');
    if(role == '"""),_display_(/*107.18*/Role/*107.22*/.DEVELOPER.name),format.raw/*107.37*/("""')"""),format.raw/*107.39*/("""{"""),format.raw/*107.40*/("""
      """),format.raw/*108.7*/("""writeButton.addClass('active');
    """),format.raw/*109.5*/("""}"""),format.raw/*109.6*/("""
    """),format.raw/*110.5*/("""var readButton = $('<label class="btn btn-default btn-mini"><input type="radio" value=""""),_display_(/*110.93*/Role/*110.97*/.GUEST.name),format.raw/*110.108*/("""" name="' + userName + '">Guest</label>');
    if(role == '"""),_display_(/*111.18*/Role/*111.22*/.GUEST.name),format.raw/*111.33*/("""')"""),format.raw/*111.35*/("""{"""),format.raw/*111.36*/("""
      """),format.raw/*112.7*/("""readButton.addClass('active');
    """),format.raw/*113.5*/("""}"""),format.raw/*113.6*/("""

    """),format.raw/*115.5*/("""$(id).append($('<li>')
      .data('name', userName)
      .append($('<div class="btn-group role" data-toggle="buttons">')
        .append(adminButton)
        .append(writeButton)
        .append(readButton))
      .append(' ')
      .append($('<a target="_blank">').attr('href', '"""),_display_(/*122.55*/context/*122.62*/.path),format.raw/*122.67*/("""/' + userName).text(userName))
      .append($('<a href="#" class="remove pull-right">(remove)</a>')));
  """),format.raw/*124.3*/("""}"""),format.raw/*124.4*/("""

  """),format.raw/*126.3*/("""function updateValues()"""),format.raw/*126.26*/("""{"""),format.raw/*126.27*/("""
    """),format.raw/*127.5*/("""var collaborators = $('#collaborator-list li').map(function(i, e)"""),format.raw/*127.70*/("""{"""),format.raw/*127.71*/("""
      """),format.raw/*128.7*/("""var userName = $(e).data('name');
      return userName + ':' + $(e).find('label.active input[type=radio]').attr('value');
    """),format.raw/*130.5*/("""}"""),format.raw/*130.6*/(""").get().join(',');

    var groups = $('#group-list li').map(function(i, e)"""),format.raw/*132.56*/("""{"""),format.raw/*132.57*/("""
      """),format.raw/*133.7*/("""var userName = $(e).data('name');
      return userName + ':' + $(e).find('label.active input[type=radio]').attr('value');
    """),format.raw/*135.5*/("""}"""),format.raw/*135.6*/(""").get().join(',');

    $('#collaborators').val(collaborators + ',' + groups);
  """),format.raw/*138.3*/("""}"""),format.raw/*138.4*/("""
"""),format.raw/*139.1*/("""}"""),format.raw/*139.2*/(""");
</script>
"""))
      }
    }
  }

  def render(collaborators:List[(gitbucket.core.model.Collaborator, Boolean)],isGroupRepository:Boolean,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(collaborators,isGroupRepository,repository)(context)

  def f:((List[(gitbucket.core.model.Collaborator, Boolean)],Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (collaborators,isGroupRepository,repository) => (context) => apply(collaborators,isGroupRepository,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/settings/collaborators.scala.html
                  HASH: 86df5134a7b4d6add47cd4858da31f2c2dc230ce
                  MATRIX: 734->1|1028->224|1070->260|1131->294|1148->303|1201->348|1239->349|1268->353|1285->362|1332->401|1370->402|1401->408|1418->417|1479->470|1517->471|1550->478|1615->517|1630->524|1666->540|1971->818|1989->827|2078->895|2119->908|2585->1347|2603->1356|2685->1417|2726->1430|3209->1883|3243->1887|3275->1889|3303->1890|3352->1911|3381->1912|3411->1915|3479->1955|3508->1956|3540->1961|3585->1979|3613->1980|3673->2012|3702->2013|3734->2018|3969->2225|3998->2226|4032->2233|4077->2251|4105->2252|4138->2258|4198->2291|4217->2301|4244->2307|4299->2334|4328->2335|4362->2342|4474->2427|4502->2428|4534->2433|4642->2513|4671->2514|4705->2521|4777->2566|4805->2567|4861->2595|4890->2596|4924->2603|5031->2683|5059->2684|5092->2690|5151->2722|5167->2729|5193->2734|5240->2753|5269->2754|5298->2755|5347->2776|5376->2777|5434->2807|5463->2808|5499->2817|5541->2831|5570->2832|5609->2843|5660->2867|5673->2871|5705->2882|5804->2954|5833->2955|5862->2956|5895->2961|5924->2962|5963->2973|6046->3029|6075->3030|6109->3037|6137->3038|6169->3043|6197->3044|6276->3095|6305->3096|6337->3101|6393->3130|6421->3131|6556->3238|6585->3239|6617->3244|6673->3273|6701->3274|6734->3281|6756->3294|6769->3298|6841->3332|6873->3337|6914->3351|6935->3363|6973->3380|7005->3385|7026->3397|7052->3402|7094->3417|7133->3418|7171->3436|7211->3437|7264->3458|7300->3464|7332->3468|7401->3508|7431->3509|7464->3514|7581->3603|7595->3607|7629->3618|7717->3678|7731->3682|7764->3693|7795->3695|7825->3696|7860->3703|7924->3739|7953->3740|7986->3745|8103->3834|8117->3838|8155->3853|8247->3917|8261->3921|8298->3936|8329->3938|8359->3939|8394->3946|8458->3982|8487->3983|8520->3988|8636->4076|8650->4080|8684->4091|8772->4151|8786->4155|8819->4166|8850->4168|8880->4169|8915->4176|8978->4211|9007->4212|9041->4218|9352->4501|9369->4508|9396->4513|9530->4619|9559->4620|9591->4624|9643->4647|9673->4648|9706->4653|9800->4718|9830->4719|9865->4726|10020->4853|10049->4854|10153->4929|10183->4930|10218->4937|10373->5064|10402->5065|10511->5146|10540->5147|10569->5148|10598->5149
                  LINES: 14->1|19->4|20->5|23->6|23->6|23->6|23->6|24->7|24->7|24->7|24->7|25->8|25->8|25->8|25->8|26->9|26->9|26->9|26->9|32->15|32->15|32->15|33->16|45->28|45->28|45->28|46->29|58->41|59->42|60->43|61->44|62->45|62->45|63->46|63->46|63->46|64->47|65->48|65->48|67->50|67->50|68->51|74->57|74->57|75->58|76->59|76->59|78->61|79->62|79->62|79->62|80->63|80->63|81->64|83->66|83->66|84->67|85->68|85->68|86->69|87->70|87->70|88->71|88->71|89->72|91->74|91->74|93->76|94->77|94->77|94->77|94->77|94->77|94->77|94->77|94->77|95->78|95->78|96->79|96->79|96->79|97->80|97->80|97->80|97->80|99->82|99->82|99->82|99->82|99->82|100->83|101->84|101->84|102->85|102->85|103->86|103->86|105->88|105->88|106->89|107->90|107->90|110->93|110->93|111->94|112->95|112->95|114->97|114->97|114->97|114->97|115->98|115->98|115->98|115->98|115->98|115->98|115->98|115->98|115->98|115->98|115->98|115->98|116->99|118->101|118->101|118->101|119->102|119->102|119->102|119->102|120->103|120->103|120->103|120->103|120->103|121->104|122->105|122->105|123->106|123->106|123->106|123->106|124->107|124->107|124->107|124->107|124->107|125->108|126->109|126->109|127->110|127->110|127->110|127->110|128->111|128->111|128->111|128->111|128->111|129->112|130->113|130->113|132->115|139->122|139->122|139->122|141->124|141->124|143->126|143->126|143->126|144->127|144->127|144->127|145->128|147->130|147->130|149->132|149->132|150->133|152->135|152->135|155->138|155->138|156->139|156->139
                  -- GENERATED --
              */
          