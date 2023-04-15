import sys
import requests
from bs4 import BeautifulSoup
from getopt import getopt


def write_data_to_cache(cache_data):
	with open(CACHE_FILE_NAME, mode="w", encoding="utf-8") as file:
		file.write(cache_data)

def get_data_from_cache():
	with open(CACHE_FILE_NAME, mode="r", encoding="utf-8") as file:
		content = file.read()
	return content

def get_data_from_source():
	response = requests.get(SOURCE_URL)
	response.raise_for_status()

	return response.text


CACHE_FILE_NAME = 'cache_data.html'
REFRESH_DATA = False
SOURCE_URL = 'https://www.booking.com/searchresults.en-gb.html?label=gen173nr-1FCAEoggJCAlhYSDNYBGgxiAEBmAEuwgEDYWJuyAEO2AEB6AEB-AELkgIBeagCBA&sid=1964712b1d001062109ae5baf669fd26&checkin_month=12&checkin_monthday=1&checkin_year=2018&checkout_month=12&checkout_monthday=2&checkout_year=2018&class_interval=1&dest_id=20088325&dest_type=city&dtdisc=0&from_sf=1&group_adults=1&group_children=0&inac=0&index_postcard=0&label_click=undef&no_rooms=1&offset=0&postcard=0&raw_dest_type=city&room1=A&sb_price_type=total&src=index&src_elem=sb&ss=New%20York&ss_all=0&ssb=empty&sshis=0&ssne=New%20York&ssne_untouched=New%20York&selected_currency=USD&changed_currency=1&top_currency=1&nflt='

try:
	opts, args = getopt(sys.argv[1:], "rf:", ["refresh", "filename="])
except:
	print('Invalid args passed')

for opt, arg in opts:
	if opt in ['-f', '--filename']:
		CACHE_FILE_NAME = arg
	elif opt in ['-r', '--refresh']:
		REFRESH_DATA = True
	else:
		print('Invalid args passed')
		sys.exit(2)


print('---- Arguments Passed ----')
print(f'CACHE_FILE_NAME = {CACHE_FILE_NAME}')
print(f"REFRESH_DATA = {'Yes' if REFRESH_DATA else 'No'}")

data = None

if REFRESH_DATA:
	data = get_data_from_source()
	write_data_to_cache(data)
else:
	data = get_data_from_cache()

soup = BeautifulSoup(data, 'html.parser')

for hotel_data in soup.select("div.sr__card_content"):
	hotel_name = str(hotel_data.select_one("span.bui-card__title").text).strip()
	hotel_price = str(hotel_data.select_one("div.bui-price-display__value").text).strip()
	print(hotel_name, hotel_price)
