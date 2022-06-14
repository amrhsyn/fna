package me.ahch.fleetlist_data.remote

val malformedFleetListResponse = """
    {
        "poiadfList": [
            {
                "iddfadf": 458000,
                "coadfordinate": {
                    "latitude": 53.40832384357247,
                    "longitude": 9.92320400671585
                },
                "fleetType": "TAXI",
                "heading": 170.91219642299959
            },
            {
                "id": 286920,
                "coordinate": {
                    "latitude": 53.45365557621811,
                    "longitude": 9.924860631466661
                },
                "fleetType": "TAXI",
                "heading": 131.41677396054436
            },
            {
                "id": 956957,
                "coordinate": {
                    "latitude": 53.68702001275049,
                    "longitude": 9.870586998670998
                },
                "fleetType": "TAXI",
                "heading": 188.5699524672293
            },
            {
                "id": 232935,
                "coordinate": {
                    "latitude": 53.47086814919625,
                    "longitude": 10.052651124623777
                },
                "fleetType": "POOLING",
                "heading": 108.79974706086568
            },
            {
                "id": 688473,
                "coordinate": {
                    "latitude": 53.627831617290546,
                    "longitude": 9.818667746905316
                },
                "fleetType": "POOLING",
                "heading": 103.63647528217395
            },
            {
                "id": 895321,
                "coordinate": {
                    "latitude": 53.56741413089023,
                    "longitude": 10.042577938686515
                },
                "fleetType": "POOLING",
                "heading": 53.91124810495972
            },
            {
                "id": 401680,
                "coordinate": {
                    "latitude": 53.652507642785764,
                    "longitude": 10.05728246861712
                },
                "fleetType": "TAXI",
                "heading": 114.51955954802283
            },
            {
                "id": 862010,
                "coordinate": {
                    "latitude": 53.57861558574541,
                    "longitude": 9.851899965178584
                },
                "fleetType": "TAXI",
                "heading": 350.1470250397258
            },
            {
                "iadfadd": 918663,
                "coordiadfanate": {
                    "latitude": 53.62442431036257,
                    "longitude": 10.027400939283316
                },
                "fleetType": "POOLING",
                "heading": 333.8047560321634
            },
            {
                "id": 959689,
                "coordinate": {
                    "latitude": 53.496887587452015,
                    "longitude": 10.001347008678072
                },
                "fleetType": "TAXI",
                "heading": 232.34383061510337
            },
            {
                "id": 494490,
                "coordinate": {
                    "latitude": 53.48900555553859,
                    "longitude": 9.80779358920749
                },
                "fleetType": "TAXI",
                "heading": 277.81827364254707
            },
            {
                "id": 813135,
                "coordinate": {
                    "latitude": 53.659911084298166,
                    "longitude": 10.0462577588937
                },
                "fleetType": "TAXI",
                "heading": 203.29954392508384
            },
            {
                "id": 628879,
                "coordinate": {
                    "latitude": 53.427408587108715,
                    "longitude": 9.774873113924444
                },
                "fleetType": "TAXI",
                "heading": 61.37592727965673
            },
            {
                "id": 381876,
                "coordinate": {
                    "latitude": 53.45690536640358,
                    "longitude": 10.035252230342921
                },
                "fleetType": "POOLING",
                "heading": 20.464059821850192
            },
            {
                "id": 961751,
                "coordinate": {
                    "latitude": 53.49526172140492,
                    "longitude": 9.938156771809505
                },
                "fleetType": "POOLING",
                "heading": 250.62547283968448
            },
            {
                "id": 568354,
                "coordinate": {
                    "latitude": 53.629836127019765,
                    "longitude": 9.82503397389659
                },
                "fleetType": "TAXI",
                "heading": 175.7109424398464
            },
            {
                "id": 516941,
                "coordinate": {
                    "latitude": 53.579263183715454,
                    "longitude": 9.889992325922544
                },
                "fleetType": "POOLING",
                "heading": 141.16280770527342
            },
            {
                "id": 500903,
                "coordinate": {
                    "latitude": 53.565475862462,
                    "longitude": 9.850942502586665
                },
                "fleetType": "POOLING",
                "heading": 100.9915358089885
            },
            {
                "id": 249026,
                "coordinate": {
                    "latitude": 53.666748602499865,
                    "longitude": 10.07007299212701
                },
                "fleetType": "POOLING",
                "heading": 54.833340235261495
            },
            {
                "id": 315505,
                "coordinate": {
                    "latitude": 53.615517430704685,
                    "longitude": 10.064947497190317
                },
                "fleetType": "TAXI",
                "heading": 162.0053095845093
            },
            {
                "id": 477211,
                "coordinate": {
                    "latitude": 53.479296969538794,
                    "longitude": 10.099578567225365
                },
                "fleetType": "POOLING",
                "heading": 113.23907818630862
            },
            {
                "id": 873059,
                "coordinate": {
                    "latitude": 53.58716056007686,
                    "longitude": 9.757667759550037
                },
                "fleetType": "POOLING",
                "heading": 54.98597050857656
            },
            {
                "id": 995728,
                "coordinate": {
                    "latitude": 53.61408943832019,
                    "longitude": 9.815297141177004
                },
                "fleetType": "POOLING",
                "heading": 291.0782074569255
            },
            {
                "id": 836649,
                "coordinate": {
                    "latitude": 53.490443554952954,
                    "longitude": 9.774041584842031
                },
                "fleetType": "TAXI",
                "heading": 10.329782933523083
            },
            {
                "id": 265938,
                "coordinate": {
                    "latitude": 53.40198634177294,
                    "longitude": 9.869770880548849
                },
                "fleetType": "TAXI",
                "heading": 160.89403949653064
            },
            {
                "id": 482165,
                "coordinate": {
                    "latitude": 53.59584036013404,
                    "longitude": 10.074660952457256
                },
                "fleetType": "TAXI",
                "heading": 114.10717987632546
            },
            {
                "id": 767082,
                "coordinate": {
                    "latitude": 53.56327449566799,
                    "longitude": 9.76914608067071
                },
                "adfadf": "TAXI",
                "heading": 268.01904417643493
            },
            {
                "iadfd": 504335,
                "codafordinate": {
                    "latitude": 53.651824195903004,
                    "longitude": 9.837384386439512
                },
                "fleetType": "TAXI",
                "heading": 323.8449817840604
            },
            {
                "id": 864758,
                "coordinate": {
                    "latitude": 53.56542026831759,
                    "longitude": 10.045495347927428
                },
                "fleetType": "TAXI",
                "heading": 331.13511089013826
            },
            {
                "id": 104772,
                "coordinate": {
                    "latitude": 53.69271904862556,
                    "longitude": 9.810249541700328
                },
                "fleetType": "POOLING",
                "heading": 89.53011757095405
            }
        ]
    }
""".trimIndent()